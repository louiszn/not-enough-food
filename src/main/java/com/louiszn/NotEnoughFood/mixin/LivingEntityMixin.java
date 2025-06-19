package com.louiszn.NotEnoughFood.mixin;

import com.louiszn.NotEnoughFood.listener.ItemListener;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Unique
    public Random random = new Random();

    @Inject(
            method = "dropItems",
            at = @At("HEAD"),
            cancellable = true
    )
    private void dropItems(CallbackInfo ci) {
        if ((Object) this instanceof CowEntity self) {
            int leatherCount = this.random.nextInt(3); // 0 - 2

            for (int count = 0; count < leatherCount; ++count) {
                self.dropItem(Item.LEATHER.id, 1);
            }

            int rawBeefCount = this.random.nextInt(3); // 0 - 2

            for (int count = 0; count < rawBeefCount; ++count) {
                self.dropItem(ItemListener.rawBeef.id, 1);
            }

            ci.cancel();
        }

        if ((Object) this instanceof ChickenEntity self) {
            int featherCount = this.random.nextInt(3); // 0 - 2

            for (int count = 0; count < featherCount; ++count) {
                self.dropItem(Item.FEATHER.id, 1);
            }

            int rawChickenCount = this.random.nextInt(2);

            for (int count = 0; count < rawChickenCount; ++count) {
                self.dropItem(ItemListener.rawChicken.id, 1);
            }

            ci.cancel();
        }

        if ((Object) this instanceof ZombieEntity self) {
            if (this.random.nextFloat() <= 0.4F) {
                self.dropItem(this.random.nextFloat() <= 0.5F ? ItemListener.carrot.id : ItemListener.potato.id, 1);
            }

            ci.cancel();
        }
    }
}
