package net.ninjadev.ninjamulti.api.platform.client;

import net.ninjadev.ninjamulti.api.services.client.IClientRegistrar;
import net.ninjadev.ninjamulti.api.services.client.IClientRegistrarFactory;

public class FabricClientRegistrarFactory implements IClientRegistrarFactory {

    @Override
    public IClientRegistrar create(Object... context) {
        return new FabricClientRegistrar();
    }
}
