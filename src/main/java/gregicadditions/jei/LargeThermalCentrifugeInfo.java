package gregicadditions.jei;

import com.google.common.collect.Lists;
import gregicadditions.blocks.GAMetalCasing;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.machines.GATileEntities;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

public class LargeThermalCentrifugeInfo extends MultiblockInfoPage {
    @Override
    public MultiblockControllerBase getController() {
        return GATileEntities.LARGE_THERMAL_CENTRIFUGE;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        for (BlockWireCoil.CoilType coilType : BlockWireCoil.CoilType.values()) {
            shapeInfo.add(MultiblockShapeInfo.builder()
                    .aisle("XXX", "XXX")
                    .aisle("IXX", "X#X")
                    .aisle("OXX", "XSX")
                    .where('S', GATileEntities.LARGE_THERMAL_CENTRIFUGE, EnumFacing.SOUTH)
                    .where('C', MetaBlocks.WIRE_COIL.getState(coilType))
                    .where('X', GAMetaBlocks.METAL_CASING.getState(GAMetalCasing.MetalCasingType.RED_STEEL_CASING))
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.WEST)
                    .where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.WEST)
                    .build());
        }

        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("gregtech.multiblock.large_thermal_centrifuge.description")};
    }
}
