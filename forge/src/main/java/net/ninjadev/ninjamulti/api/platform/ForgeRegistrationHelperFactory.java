package net.ninjadev.ninjamulti.api.platform;

import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.ninjadev.ninjamulti.api.services.IRegistrationHelper;
import net.ninjadev.ninjamulti.api.services.IRegistrationHelperFactory;

public class ForgeRegistrationHelperFactory implements IRegistrationHelperFactory {

    @Override
    public IRegistrationHelper create(String modId, Object... context) {
        BusGroup modBusGroup = (BusGroup) context[0];
        return new ForgeRegistrationHelper(modId, modBusGroup);
    }
}
