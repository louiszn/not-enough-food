package com.louiszn.NotEnoughFood.listener;

import com.louiszn.NotEnoughFood.item.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();

    public static final int MAX_FOOD_COUNT = 16;

    public static Item potato;
    public static Item bakedPotato;
    public static Item poisonousPotato;
    public static Item potatoSoup;
    public static Item carrot;
    public static Item carrotSoup;
    public static Item goldenCarrot;
    public static Item cookedPorkchop;
    public static Item rawPorkchop;
    public static Item rawBeef;
    public static Item cookedBeef;
    public static Item rawMutton;
    public static Item cookedMutton;
    public static Item rawChicken;
    public static Item cookedChicken;
    public static Item apple;
    public static Item goldenApple;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        potato = new PotatoItem(MOD_ID.id("potato")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "potato");
        bakedPotato = new BakedPotatoItem(MOD_ID.id("baked_potato")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "baked_potato");
        poisonousPotato = new PoisonousPotatoItem(MOD_ID.id("poisonous_potato")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "poisonous_potato");
        potatoSoup = new PotatoSoupItem(MOD_ID.id("potato_soup")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "potato_soup");

        carrot = new CarrotItem(MOD_ID.id("carrot")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "carrot");
        carrotSoup = new CarrotSoupItem(MOD_ID.id("carrot_soup")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "carrot_soup");
        goldenCarrot = new GoldenCarrotItem(MOD_ID.id("golden_carrot")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "golden_carrot");

        cookedPorkchop = Item.COOKED_PORKCHOP.setMaxCount(MAX_FOOD_COUNT);
        rawPorkchop = Item.RAW_PORKCHOP.setMaxCount(MAX_FOOD_COUNT);

        rawBeef = new RawBeefItem(MOD_ID.id("raw_beef")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "raw_beef");
        cookedBeef = new CookedBeefItem(MOD_ID.id("cooked_beef")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "cooked_beef");

        rawMutton = new RawMuttonItem(MOD_ID.id("raw_mutton")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "raw_mutton");
        cookedMutton = new CookedMuttonItem(MOD_ID.id("cooked_mutton")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "cooked_mutton");

        rawChicken = new RawChickenItem(MOD_ID.id("raw_chicken")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "raw_chicken");
        cookedChicken = new CookedChickenItem(MOD_ID.id("cooked_chicken")).setMaxCount(MAX_FOOD_COUNT).setTranslationKey(MOD_ID, "cooked_chicken");

        apple = Item.APPLE.setMaxCount(MAX_FOOD_COUNT);
        goldenApple = Item.GOLDEN_APPLE.setMaxCount(MAX_FOOD_COUNT);
    }
}
