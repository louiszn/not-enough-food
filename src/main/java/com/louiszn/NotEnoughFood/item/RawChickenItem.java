package com.louiszn.NotEnoughFood.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class RawChickenItem extends TemplateFoodItem {
    public RawChickenItem(Identifier identifier) {
        super(identifier, 3, false);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        --stack.count;

        if (world.random.nextFloat() <= 0.2F) {
            user.damage(null, this.getHealthRestored());
        } else {
            user.heal(this.getHealthRestored());
        }

        return stack;
    }
}
