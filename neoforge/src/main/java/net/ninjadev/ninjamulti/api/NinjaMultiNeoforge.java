package net.ninjadev.ninjamulti.api;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class NinjaMultiNeoforge {
    public NinjaMultiNeoforge(IEventBus eventBus) {
        NinjaMultiCommon.init();
    }
}
