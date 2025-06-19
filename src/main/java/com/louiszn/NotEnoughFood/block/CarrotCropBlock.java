package com.louiszn.NotEnoughFood.block;

import com.louiszn.NotEnoughFood.listener.ItemListener;
import com.louiszn.NotEnoughFood.listener.TextureListener;
import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateCropBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class CarrotCropBlock extends TemplateCropBlock {
    public CarrotCropBlock(Identifier identifier) {
        super(identifier, 0);
        this.setTickRandomly(true);
        this.setSoundGroup(Block.DIRT_SOUND_GROUP);
    }

    @Override
    public void dropStacks(World world, int x, int y, int z, int meta, float luck) {
        if (!world.isRemote && (meta == 7 || meta == 0)) {
            int count = meta == 7 ? getDroppedItemCount(world.random) : 1;

            float offsetRange = 0.7F;

            for (int i = 0; i < count; i++) {
                float offsetX = world.random.nextFloat() * offsetRange + (1.0F - offsetRange) * 0.5F;
                float offsetY = world.random.nextFloat() * offsetRange + (1.0F - offsetRange) * 0.5F;
                float offsetZ = world.random.nextFloat() * offsetRange + (1.0F - offsetRange) * 0.5F;

                ItemEntity item = new ItemEntity(
                        world,
                        (float) x + offsetX,
                        (float) y + offsetY,
                        (float) z + offsetZ,
                        new ItemStack(ItemListener.carrot)
                );

                item.pickupDelay = 10;
                world.spawnEntity(item);
            }
        }
    }

    @Override
    public int getDroppedItemId(int meta, Random random) {
        return meta == 7 ? ItemListener.potato.id : -1;
    }

    @Override
    public int getDroppedItemCount(Random random) {
        return 2 + random.nextInt(3);
    }

    @Override
    public int getTexture(int side, int meta) {
        return TextureListener.carrotCropTextures[Math.min(meta * 4 / 8, 3)];
    }
}
