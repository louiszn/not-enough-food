package com.louiszn.NotEnoughFood.item;

import com.louiszn.NotEnoughFood.listener.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class CarrotItem extends TemplateFoodItem {
    public CarrotItem(Identifier identifier) {
        super(identifier, 3, false);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        if (side != 1) {
            return false;
        }

        int blockId = world.getBlockId(x, y, z);

        if (blockId == Block.FARMLAND.id && world.isAir(x, y + 1, z)) {
            world.setBlock(x, y + 1, z, BlockListener.carrotCrop.id);
            --stack.count;
            return true;
        }

        return false;
    }
}
