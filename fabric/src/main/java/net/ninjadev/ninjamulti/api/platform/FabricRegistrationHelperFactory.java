package net.ninjadev.ninjamulti.api.platform;

import net.ninjadev.ninjamulti.api.services.IRegistrationHelper;
import net.ninjadev.ninjamulti.api.services.IRegistrationHelperFactory;

public class FabricRegistrationHelperFactory implements IRegistrationHelperFactory {

    @Override
    public IRegistrationHelper create(String modId, Object... context) {
        return new FabricRegistrationHelper(modId);
    }
}
