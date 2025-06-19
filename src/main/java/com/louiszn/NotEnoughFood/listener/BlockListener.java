package com.louiszn.NotEnoughFood.listener;

import com.louiszn.NotEnoughFood.block.CarrotCropBlock;
import com.louiszn.NotEnoughFood.block.PotatoCropBlock;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {
    @Entrypoint.Namespace
    public static Namespace MOD_ID = Null.get();

    public static Block potatoCrop;
    public static Block carrotCrop;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        potatoCrop = new PotatoCropBlock(MOD_ID.id("potato_crop")).setTranslationKey(MOD_ID, "potato_crop");
        carrotCrop = new CarrotCropBlock(MOD_ID.id("carrot_crop")).setTranslationKey(MOD_ID, "carrot_crop");

        Block.BLOCKS_IGNORE_META_UPDATE[potatoCrop.id] = true;
        Block.BLOCKS_IGNORE_META_UPDATE[carrotCrop.id] = true;
    }
}
