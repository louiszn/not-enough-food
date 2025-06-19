package com.louiszn.NotEnoughFood.item;

import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class CookedChickenItem extends TemplateFoodItem {
    public CookedChickenItem(Identifier identifier) {
        super(identifier, 8, false);
    }
}
