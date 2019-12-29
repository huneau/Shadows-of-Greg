package gregicadditions.machines;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.render.ICubeRenderer;
import gregtech.api.render.Textures;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.util.ResourceLocation;

public class TileEntityFissionReactor extends MultiblockWithDisplayBase {


	public TileEntityFissionReactor(ResourceLocation metaTileEntityId) {
		super(metaTileEntityId);
	}

	@Override
	protected void updateFormedValid() {

	}

	@Override
	protected BlockPattern createStructurePattern() {
		return null;
	}

	@Override
	public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
		return MetaBlocks.CONCRETE;
	}

	@Override
	public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
		return new TileEntityFissionReactor(metaTileEntityId);
	}
}
