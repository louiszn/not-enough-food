package com.louiszn.NotEnoughFood.item;

import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public abstract class PlantableFoodItem extends TemplateFoodItem {
    public PlantableFoodItem(Identifier identifier, int healAmount, boolean isWolfFood) {
        super(identifier, healAmount, isWolfFood);
    }

    private boolean isCropBlock(Block block) {
        return block instanceof CropBlock;
    }

    public int getCropBlockId() {
        return -1;
    }

    public int getCropBlockMeta() {
        return 0;
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        int blockId = world.getBlockId(x, y, z);
        Block block = BlockRegistry.INSTANCE.get(blockId);

        if (isCropBlock(block)) {
            return true;
        }

        if (side == 1 && blockId == Block.FARMLAND.id && world.isAir(x, y + 1, z)) {
            world.setBlock(x, y + 1, z, getCropBlockId(), getCropBlockMeta());
            --stack.count;
            return true;
        }

        return false;
    }
}
