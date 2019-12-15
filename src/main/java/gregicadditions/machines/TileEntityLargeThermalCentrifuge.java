package gregicadditions.machines;

import gregicadditions.blocks.GAMetalCasing;
import gregicadditions.client.ClientHandler;
import gregicadditions.item.GAMetaBlocks;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.multiblock.FactoryBlockPattern;
import gregtech.api.multiblock.PatternMatchContext;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.render.ICubeRenderer;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.metatileentities.multi.electric.MetaTileEntityElectricBlastFurnace;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class TileEntityLargeThermalCentrifuge extends RecipeMapMultiblockController {

	private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {MultiblockAbility.IMPORT_ITEMS, MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.INPUT_ENERGY};


	public TileEntityLargeThermalCentrifuge(ResourceLocation metaTileEntityId) {
		super(metaTileEntityId, RecipeMaps.THERMAL_CENTRIFUGE_RECIPES);
		MultiThermalCentrifugeRecipeLogic multiblockRecipeLogic = new MultiThermalCentrifugeRecipeLogic(this);
		this.recipeMapWorkable = multiblockRecipeLogic;

	}

	@Override
	public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
		return new TileEntityLargeThermalCentrifuge(metaTileEntityId);
	}


	@Override
	protected void formStructure(PatternMatchContext context) {
		super.formStructure(context);
		BlockWireCoil.CoilType coilType = context.getOrDefault("CoilType", BlockWireCoil.CoilType.CUPRONICKEL);
	}

	@Override
	protected BlockPattern createStructurePattern() {
		return FactoryBlockPattern.start()
				.aisle("XXX", "XXX")
				.aisle("XXX", "X#X")
				.aisle("XXX", "XSX")
				.setAmountAtLeast('L', 9)
				.where('S', selfPredicate())
				.where('L', statePredicate(getCasingState()))
				.where('X', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
				.where('C', MetaTileEntityElectricBlastFurnace.heatingCoilPredicate())
				.where('#', isAirPredicate())
				.build();

	}

	public IBlockState getCasingState() {
		return GAMetaBlocks.METAL_CASING.getState(GAMetalCasing.MetalCasingType.RED_STEEL_CASING);
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
		return ClientHandler.RED_STEEL_CASING;
	}

	protected class MultiThermalCentrifugeRecipeLogic extends MultiblockRecipeLogic {

		public MultiThermalCentrifugeRecipeLogic(RecipeMapMultiblockController tileEntity) {
			super(tileEntity);
		}

		@Override
		protected Recipe findRecipe(long maxVoltage, IItemHandlerModifiable inputs, IMultipleTankHandler fluidInputs) {
			int currentItemsEngaged = 0;
			int maxItemsLimit = 8;
			int EUt = 0;
			int duration = 0;
			int currentTier = getOverclockingTier(maxVoltage);
			int tierNeeded;
			ArrayList<CountableIngredient> recipeInputs = new ArrayList<>();
			ArrayList<ItemStack> recipeOutputs = new ArrayList<>();

			for (int index = 0; index < inputs.getSlots(); index++) {
				ItemStack stackInSlot = inputs.getStackInSlot(index);
				if (stackInSlot.isEmpty())
					continue;
				Recipe matchingRecipe = recipeMap.findRecipe(maxVoltage, Collections.singletonList(stackInSlot), Collections.emptyList(), 0);
				tierNeeded = Math.max(1, matchingRecipe == null ? Integer.MAX_VALUE : getOverclockingTier(matchingRecipe.getEUt()));
				maxItemsLimit *= currentTier - tierNeeded;

				EUt = matchingRecipe == null ? 0 : matchingRecipe.getEUt();
				duration = matchingRecipe == null ? 0 : matchingRecipe.getDuration();

				CountableIngredient inputIngredient = matchingRecipe == null ? null : matchingRecipe.getInputs().get(0);
				if (inputIngredient != null && (maxItemsLimit - currentItemsEngaged) >= inputIngredient.getCount()) {
					int overclockAmount = Math.min(stackInSlot.getCount() / inputIngredient.getCount(), (maxItemsLimit - currentItemsEngaged) / inputIngredient.getCount());
					recipeInputs.add(new CountableIngredient(inputIngredient.getIngredient(), inputIngredient.getCount() * overclockAmount));
					currentItemsEngaged += inputIngredient.getCount() * overclockAmount;
					matchingRecipe.getOutputs().forEach(itemStack -> {
						ItemStack outputStack = itemStack.copy();
						if (!outputStack.isEmpty()) {
							outputStack.setCount(outputStack.getCount() * overclockAmount);
							recipeOutputs.add(outputStack);
						}
					});
				}
				if (currentItemsEngaged >= maxItemsLimit) break;
			}

			//merge recipe output because each input will need a output slot.
			ArrayList<ItemStack> mergeOutput = recipeOutputs.stream().reduce(new ArrayList<>(), (ArrayList<ItemStack> itemStacks, ItemStack itemStack) -> {
				Optional<ItemStack> result =  itemStacks.stream().filter(itemStack::isItemEqual).findFirst();
				if(result.isPresent()){
					result.get().grow(itemStack.getCount());
				}else{
					itemStacks.add(itemStack.copy());
				}
				return itemStacks;
			}, (itemStacks, itemStacks2) -> {
				itemStacks.addAll(itemStacks2);
				return itemStacks;
			});


			return recipeInputs.isEmpty() ? null : recipeMap.recipeBuilder()
					.inputsIngredients(recipeInputs)
					.outputs(mergeOutput)
					.EUt((int) Math.max(1, EUt * 0.8))
					//speed up by 150% mean divide by 2.5 but ... not sure if it's a thing implement in GT++
					.duration((int) Math.max(1.0, duration * currentItemsEngaged / 2.5))
					.build().getResult();
		}


	}
}
