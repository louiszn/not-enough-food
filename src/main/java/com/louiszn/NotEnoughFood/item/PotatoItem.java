package com.louiszn.NotEnoughFood.item;

import com.louiszn.NotEnoughFood.listener.BlockListener;
import net.modificationstation.stationapi.api.util.Identifier;

public class PotatoItem extends PlantableFoodItem {
    public PotatoItem(Identifier identifier) {
        super(identifier, 1, false);
    }

    @Override
    public int getCropBlockId() {
        return BlockListener.potatoCrop.id;
    }
}
