package com.louiszn.NotEnoughFood.mixin;

import com.louiszn.NotEnoughFood.listener.ItemListener;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin {
    @Shadow public abstract int getColor();

    @Unique
    public Random random = new Random();

    @Inject(method = "getDroppedItemId", at = @At("HEAD"), cancellable = true)
    protected void getDroppedItemId(CallbackInfoReturnable<Integer> cir) {
        cir.cancel();
    }

    @Inject(method = "dropItems", at = @At("HEAD"), cancellable = true)
    protected void dropItems(CallbackInfo ci) {
        SheepEntity self = (SheepEntity)(Object)this;

        self.dropItem(new ItemStack(Block.WOOL.id, 1, this.getColor()), 0.0F);

        int rawMuttonCount = this.random.nextInt(3);

        for(int count = 0; count < rawMuttonCount; ++count) {
            self.dropItem(ItemListener.rawMutton.id, 1);
        }

        ci.cancel();
    }
}
