package net.ninjadev.ninjamulti.api.services;

public interface IRegistrationHelperFactory {

    IRegistrationHelper create(String modId, Object... context);
}
