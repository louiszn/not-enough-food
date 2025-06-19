package com.louiszn.NotEnoughFood.item;

import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class RawBeefItem extends TemplateFoodItem {
    public RawBeefItem(Identifier identifier) {
        super(identifier, 3, false);
    }
}
