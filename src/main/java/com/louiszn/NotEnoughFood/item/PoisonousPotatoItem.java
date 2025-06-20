package com.louiszn.NotEnoughFood.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class PoisonousPotatoItem extends PlantableFoodItem {
    public PoisonousPotatoItem(Identifier identifier) {
        super(identifier, 0, false);
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity player) {
        --stack.count;
        player.damage(null, 7);
        return stack;
    }

    @Override
    public int getCropBlockId() {
        return 1;
    }

    @Override
    public int getCropBlockMeta() {
        return 2;
    }
}
