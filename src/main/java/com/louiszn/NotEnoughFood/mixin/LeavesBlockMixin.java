package com.louiszn.NotEnoughFood.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LeavesBlock.class)
public class LeavesBlockMixin extends Block {
    public LeavesBlockMixin(int id, Material material) {
        super(id, material);
    }

    @Override
    public void dropStacks(World world, int x, int y, int z, int meta, float luck) {
        if (!world.isRemote) {
            int itemCount = this.getDroppedItemCount(world.random);

            for(int count = 0; count < itemCount; ++count) {
                if (!(world.random.nextFloat() > luck)) {
                    int itemId = this.getDroppedItemId(meta, world.random);

                    if (itemId > 0) {
                        this.dropStack(world, x, y, z, new ItemStack(itemId, 1, this.getDroppedItemMeta(meta)));
                    }
                }
            }

            if ((meta & 2) == 0 && world.random.nextFloat() <= 0.2F) {
                this.dropStack(world, x, y, z, new ItemStack(Item.APPLE));
            }
        }
    }
}
