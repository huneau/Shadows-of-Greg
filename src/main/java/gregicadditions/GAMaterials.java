package gregicadditions;

import com.google.common.collect.ImmutableList;
import gregtech.api.unification.Element;
import gregtech.api.unification.material.IMaterialHandler;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.*;
import gregtech.api.unification.material.type.SolidMaterial.MatFlags;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;

@IMaterialHandler.RegisterMaterialHandler
public class GAMaterials implements IMaterialHandler {

	static long EXT2_METAL = DustMaterial.MatFlags.GENERATE_PLATE | SolidMaterial.MatFlags.GENERATE_ROD | IngotMaterial.MatFlags.GENERATE_BOLT_SCREW | SolidMaterial.MatFlags.GENERATE_GEAR | IngotMaterial.MatFlags.GENERATE_FOIL | IngotMaterial.MatFlags.GENERATE_FINE_WIRE;
	public static final FluidMaterial FISH_OIL = new FluidMaterial(975, "fish_oil", 14467421, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final FluidMaterial RAW_GROWTH_MEDIUM = new FluidMaterial(940, "raw_growth_medium", 10777425, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final FluidMaterial STERILE_GROWTH_MEDIUM = new FluidMaterial(939, "sterilized_growth_medium", 11306862, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK | Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final DustMaterial MEAT = new DustMaterial(938, "meat", 12667980, MaterialIconSet.SAND, 1, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final FluidMaterial NEUTRAL_MATTER = new FluidMaterial(883, "neutral_matter", 3956968, MaterialIconSet.FLUID, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final FluidMaterial POSITIVE_MATTER = new FluidMaterial(882, "positive_matter", 11279131, MaterialIconSet.FLUID, ImmutableList.of(), Material.MatFlags.DISABLE_DECOMPOSITION);
	public static final IngotMaterial NEUTRONIUM = new IngotMaterial(972, "neutronium", 12829635, MaterialIconSet.METALLIC, 6, ImmutableList.of(), EXT2_METAL | IngotMaterial.MatFlags.GENERATE_RING | IngotMaterial.MatFlags.GENERATE_ROTOR | IngotMaterial.MatFlags.GENERATE_SMALL_GEAR | SolidMaterial.MatFlags.GENERATE_LONG_ROD | MatFlags.GENERATE_FRAME, Element.valueOf("Nt"), 24.0F, 12F, 655360);
	public static final GemMaterial LIGNITE_COKE = new GemMaterial(879, "lignite_coke", 0x8b6464, MaterialIconSet.LIGNITE, 1, ImmutableList.of(new MaterialStack(Materials.Carbon, 1)), Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING | SolidMaterial.MatFlags.MORTAR_GRINDABLE | Material.MatFlags.FLAMMABLE | DustMaterial.MatFlags.NO_SMELTING | DustMaterial.MatFlags.NO_SMASHING);
	public static final DustMaterial PYROTHEUM = new DustMaterial(973, "pyrotheum", 0xFF9A3C, MaterialIconSet.SAND, 1, ImmutableList.of(),  Material.MatFlags.DISABLE_DECOMPOSITION | DustMaterial.MatFlags.EXCLUDE_BLOCK_CRAFTING_RECIPES);
	public static final DustMaterial EGLIN_STEEL_BASE = new DustMaterial(976, "eglin_steel_base", 0x8B4513, MaterialIconSet.SAND, 6, ImmutableList.of(new MaterialStack(Materials.Iron, 4), new MaterialStack(Materials.Kanthal, 1), new MaterialStack(Materials.Invar, 5)), 0);
	public static final IngotMaterial EGLIN_STEEL = new IngotMaterial(977, "eglin_steel", 0x8B4513, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(GAMaterials.EGLIN_STEEL_BASE, 10), new MaterialStack(Materials.Sulfur, 1), new MaterialStack(Materials.Silicon, 1), new MaterialStack(Materials.Carbon, 1)), EXT2_METAL | MatFlags.GENERATE_FRAME, null, 1048);
	public static final IngotMaterial GRISIUM = new IngotMaterial(978, "grisium", 0x355D6A, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Materials.Titanium, 9), new MaterialStack(Materials.Carbon, 9), new MaterialStack(Materials.Potassium, 9), new MaterialStack(Materials.Lithium, 9), new MaterialStack(Materials.Sulfur, 9), new MaterialStack(Materials.Hydrogen, 5)), EXT2_METAL | MatFlags.GENERATE_FRAME, null, 3850);
	public static final IngotMaterial INCONEL_625 = new IngotMaterial(979, "inconel_a", 0x80C880, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Materials.Nickel, 3), new MaterialStack(Materials.Chrome, 7), new MaterialStack(Materials.Molybdenum, 10), new MaterialStack(Materials.Invar, 10), new MaterialStack(Materials.Nichrome, 13)), EXT2_METAL | MatFlags.GENERATE_FRAME, null, 2425);
	public static final IngotMaterial MARAGING_STEEL_250 = new IngotMaterial(980, "maraging_steel_a", 0x92918D, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Materials.Steel, 16), new MaterialStack(Materials.Molybdenum, 1), new MaterialStack(Materials.Titanium, 1), new MaterialStack(Materials.Nickel, 4), new MaterialStack(Materials.Cobalt, 2)), EXT2_METAL | MatFlags.GENERATE_FRAME, null, 2413);
	public static final IngotMaterial POTIN = new IngotMaterial(981, "potin", 0xC99781, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Materials.Lead, 2), new MaterialStack(Materials.Bronze, 2), new MaterialStack(Materials.Tin, 1)), EXT2_METAL | MatFlags.GENERATE_FRAME, null );
	public static final IngotMaterial STABALLOY = new IngotMaterial(982, "staballoy", 0x444B42, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Materials.Uranium, 9), new MaterialStack(Materials.Titanium, 1)), EXT2_METAL | MatFlags.GENERATE_FRAME, null,  3450);
	public static final IngotMaterial HASTELLOY_N = new IngotMaterial(983, "hastelloy_n", 0xDDDDDD, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Materials.Yttrium, 2), new MaterialStack(Materials.Molybdenum, 4), new MaterialStack(Materials.Chrome, 2), new MaterialStack(Materials.Titanium, 2), new MaterialStack(Materials.Nickel, 15)), EXT2_METAL | MatFlags.GENERATE_FRAME, null, 4350);
	public static final IngotMaterial TUMBAGA = new IngotMaterial(984, "tumbaga", 0xFFB20F, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Materials.Gold, 7), new MaterialStack(Materials.Copper, 3)), EXT2_METAL | MatFlags.GENERATE_FRAME, null, 1200);
	public static final IngotMaterial STELLITE = new IngotMaterial(985, "stellite", 0x9991A5, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Materials.Cobalt, 9), new MaterialStack(Materials.Chrome, 9), new MaterialStack(Materials.Manganese, 5), new MaterialStack(Materials.Titanium, 2)), EXT2_METAL | MatFlags.GENERATE_FRAME, null, 4310);
	public static final IngotMaterial TALONITE = new IngotMaterial(986, "talonite", 0x9991A5, MaterialIconSet.METALLIC, 6, ImmutableList.of(new MaterialStack(Materials.Cobalt, 4), new MaterialStack(Materials.Chrome, 3), new MaterialStack(Materials.Phosphorus, 2), new MaterialStack(Materials.Molybdenum, 1)), EXT2_METAL | MatFlags.GENERATE_FRAME, null, 3454);

	@Override
	public void onMaterialsInit() {
		LIGNITE_COKE.setBurnTime(2400);

		Materials.YttriumBariumCuprate.addFlag(IngotMaterial.MatFlags.GENERATE_FINE_WIRE);
		Materials.Manganese.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.Naquadah.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.NaquadahEnriched.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.Duranium.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.Graphene.addFlag(IngotMaterial.MatFlags.GENERATE_FOIL);
		Materials.Helium.addFlag(FluidMaterial.MatFlags.GENERATE_PLASMA);
		Materials.Oxygen.addFlag(FluidMaterial.MatFlags.GENERATE_PLASMA);
		Materials.Iron.addFlag(FluidMaterial.MatFlags.GENERATE_PLASMA);
		Materials.Nickel.addFlag(FluidMaterial.MatFlags.GENERATE_PLASMA);
		Materials.GreenSapphire.addFlag(DustMaterial.MatFlags.GENERATE_PLATE);
		Materials.GreenSapphire.addFlag(GemMaterial.MatFlags.GENERATE_LENSE);
		Materials.Tritanium.addFlag(MatFlags.GENERATE_FRAME);
		Materials.RedSteel.addFlag(MatFlags.GENERATE_FRAME | MatFlags.GENERATE_GEAR);

		Materials.Apatite.addFlag(SolidMaterial.MatFlags.GENERATE_ROD);

		Materials.Iron.addFlag(SolidMaterial.MatFlags.GENERATE_LONG_ROD);
		Materials.Bronze.addFlag(SolidMaterial.MatFlags.GENERATE_LONG_ROD);
		Materials.Steel.addFlag(SolidMaterial.MatFlags.GENERATE_LONG_ROD);
		Materials.StainlessSteel.addFlag(SolidMaterial.MatFlags.GENERATE_LONG_ROD);

		Materials.Steel.addFlag(Material.MatFlags.DISABLE_DECOMPOSITION);

		Materials.Rubber.addFlag(IngotMaterial.MatFlags.GENERATE_BOLT_SCREW);
		Materials.Apatite.addFlag(IngotMaterial.MatFlags.GENERATE_BOLT_SCREW);

		Materials.Salt.addOreByProducts(Materials.Borax);
		Materials.RockSalt.addOreByProducts(Materials.Borax);
		Materials.Lepidolite.addOreByProducts(Materials.Boron);

		OrePrefix.gemChipped.setIgnored(LIGNITE_COKE);
		OrePrefix.gemFlawed.setIgnored(LIGNITE_COKE);
		OrePrefix.gemFlawless.setIgnored(LIGNITE_COKE);
		OrePrefix.gemExquisite.setIgnored(LIGNITE_COKE);

		Materials.Magnetite.setDirectSmelting(Materials.Iron);
	}
}