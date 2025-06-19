package com.louiszn.NotEnoughFood.listener;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;

public class TextureListener {
    @Entrypoint.Namespace
    public static Namespace MOD_ID;

    public static final int[] potatoCropTextures = new int[4];
    public static final int[] carrotCropTextures = new int[4];

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        ExpandableAtlas terrainAtlas = Atlases.getTerrain();

        for (int i = 0; i < 4; i++) {
            potatoCropTextures[i] = terrainAtlas.addTexture(MOD_ID.id("block/potatoes_stage" + i)).index;
        }

        for (int i = 0; i < 4; i++) {
            carrotCropTextures[i] = terrainAtlas.addTexture(MOD_ID.id("block/carrots_stage" + i)).index;
        }

        this.registerItemTextures();
        this.registerBlockTextures();
    }

    public void registerItemTextures() {
        ItemListener.rawPorkchop.setTexture(MOD_ID.id("item/porkchop"));
        ItemListener.cookedPorkchop.setTexture(MOD_ID.id("item/cooked_porkchop"));

        ItemListener.potato.setTexture(MOD_ID.id("item/potato"));
        ItemListener.bakedPotato.setTexture(MOD_ID.id("item/baked_potato"));
        ItemListener.poisonousPotato.setTexture(MOD_ID.id("item/poisonous_potato"));
        ItemListener.potatoSoup.setTexture(MOD_ID.id("item/potato_soup"));

        ItemListener.carrot.setTexture(MOD_ID.id("item/carrot"));
        ItemListener.carrotSoup.setTexture(MOD_ID.id("item/carrot_soup"));
        ItemListener.goldenCarrot.setTexture(MOD_ID.id("item/golden_carrot"));

        ItemListener.rawBeef.setTexture(MOD_ID.id("item/raw_beef"));
        ItemListener.cookedBeef.setTexture(MOD_ID.id("item/cooked_beef"));

        ItemListener.rawMutton.setTexture(MOD_ID.id("item/raw_mutton"));
        ItemListener.cookedMutton.setTexture(MOD_ID.id("item/cooked_mutton"));

        ItemListener.rawChicken.setTexture(MOD_ID.id("item/raw_chicken"));
        ItemListener.cookedChicken.setTexture(MOD_ID.id("item/cooked_chicken"));

        BlockListener.potatoCrop.asItem().setTexture(MOD_ID.id("block/potatoes_stage0"));
        BlockListener.carrotCrop.asItem().setTexture(MOD_ID.id("block/carrots_stage0"));
    }

    public void registerBlockTextures() {
        BlockListener.potatoCrop.textureId = potatoCropTextures[0];
        BlockListener.carrotCrop.textureId = carrotCropTextures[0];
    }
}
