package gregicadditions.blocks;

import gregtech.common.blocks.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class GAMetalCasing extends VariantBlock<GAMetalCasing.MetalCasingType> {

	public GAMetalCasing() {
		super(Material.IRON);
		setTranslationKey("ga_metal_casing");
		setHardness(5.0f);
		setResistance(10.0f);
		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 2);
		setDefaultState(getState(GAMetalCasing.MetalCasingType.RED_STEEL_CASING));
	}

	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
		return false;
	}

	public enum MetalCasingType implements IStringSerializable {

		RED_STEEL_CASING("red_steel");

		private final String name;

		MetalCasingType(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

	}
}
