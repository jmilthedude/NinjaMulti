package net.ninjadev.ninjamulti.api.platform.client;

import net.ninjadev.ninjamulti.api.services.client.IClientRegistrar;
import net.ninjadev.ninjamulti.api.services.client.IClientRegistrarFactory;

public class ForgeClientRegistrarFactory implements IClientRegistrarFactory {

    @Override
    public IClientRegistrar create(Object... context) {
        return new ForgeClientRegistrar();
    }
}
