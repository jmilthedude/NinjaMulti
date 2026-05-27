package net.ninjadev.ninjamulti.api.platform;

import net.neoforged.bus.api.IEventBus;
import net.ninjadev.ninjamulti.api.services.IRegistrationHelper;
import net.ninjadev.ninjamulti.api.services.IRegistrationHelperFactory;

public class NeoForgeRegistrationHelperFactory implements IRegistrationHelperFactory {

    @Override
    public IRegistrationHelper create(String modId, Object... context) {
        IEventBus modBus = (IEventBus) context[0];
        return new NeoForgeRegistrationHelper(modId, modBus);
    }
}
