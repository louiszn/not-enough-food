package com.louiszn.NotEnoughFood.item;

import com.louiszn.NotEnoughFood.listener.BlockListener;
import net.modificationstation.stationapi.api.util.Identifier;

public class CarrotItem extends PlantableFoodItem {
    public CarrotItem(Identifier identifier) {
        super(identifier, 3, false);
    }

    @Override
    public int getCropBlockId() {
        return BlockListener.carrotCrop.id;
    }
}
