package net.ninjadev.ninjamulti.api.platform;

import net.neoforged.bus.api.IEventBus;
import net.ninjadev.ninjamulti.api.services.IRegistrar;
import net.ninjadev.ninjamulti.api.services.IRegistrarFactory;

public class NeoForgeRegistrarFactory implements IRegistrarFactory {

    @Override
    public IRegistrar create(String modId, Object... context) {
        IEventBus modBus = (IEventBus) context[0];
        return new NeoForgeRegistrar(modId, modBus);
    }
}
