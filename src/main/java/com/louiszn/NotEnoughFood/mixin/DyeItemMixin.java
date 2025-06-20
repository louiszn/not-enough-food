package com.louiszn.NotEnoughFood.mixin;

import com.louiszn.NotEnoughFood.block.CarrotCropBlock;
import com.louiszn.NotEnoughFood.block.PotatoCropBlock;
import com.louiszn.NotEnoughFood.listener.BlockListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DyeItem.class)
public class DyeItemMixin {
    @Inject(
            method = "useOnBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;getBlockId(III)I",
                    shift = At.Shift.AFTER
            ),
            cancellable = true
    )
    private void useOnBlock(ItemStack stack, PlayerEntity player, World world, int x, int y, int z, int side, CallbackInfoReturnable<Boolean> cir) {
        int blockId = world.getBlockId(x, y, z);

        if (blockId == BlockListener.potatoCrop.id) {
            if (!world.isRemote) {
                ((PotatoCropBlock) BlockListener.potatoCrop).applyFullGrowth(world, x, y, z);
                --stack.count;
            }

            cir.setReturnValue(true);
        }

        if (blockId == BlockListener.carrotCrop.id) {
            if (!world.isRemote) {
                ((CarrotCropBlock) BlockListener.carrotCrop).applyFullGrowth(world, x, y, z);
                --stack.count;
            }

            cir.setReturnValue(true);
        }
    }
}
