package net.ninjadev.ninjamulti.api.platform;

import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.ninjadev.ninjamulti.api.services.IRegistrar;
import net.ninjadev.ninjamulti.api.services.IRegistrarFactory;

public class ForgeRegistrarFactory implements IRegistrarFactory {

    @Override
    public IRegistrar create(String modId, Object... context) {
        BusGroup modBusGroup = (BusGroup) context[0];
        return new ForgeRegistrar(modId, modBusGroup);
    }
}
