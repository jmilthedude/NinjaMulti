package net.ninjadev.ninjamulti.api;

import net.fabricmc.api.ModInitializer;

public class NinjaMultiFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        NinjaMultiCommon.init();
    }
}
