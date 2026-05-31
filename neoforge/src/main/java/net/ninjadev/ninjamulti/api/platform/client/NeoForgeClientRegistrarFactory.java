package net.ninjadev.ninjamulti.api.platform.client;

import net.neoforged.bus.api.IEventBus;
import net.ninjadev.ninjamulti.api.services.client.IClientRegistrar;
import net.ninjadev.ninjamulti.api.services.client.IClientRegistrarFactory;

public class NeoForgeClientRegistrarFactory implements IClientRegistrarFactory {

    @Override
    public IClientRegistrar create(Object... context) {
        IEventBus modBus = (IEventBus) context[0];
        return new NeoForgeClientRegistrar(modBus);
    }
}
