package net.ninjadev.ninjamulti.api.platform;

import net.ninjadev.ninjamulti.api.services.IRegistrar;
import net.ninjadev.ninjamulti.api.services.IRegistrarFactory;

public class FabricRegistrarFactory implements IRegistrarFactory {

    @Override
    public IRegistrar create(String modId, Object... context) {
        return new FabricRegistrar(modId);
    }
}
