package net.ninjadev.ninjamulti.api.services;

public interface IRegistrarFactory {

    IRegistrar create(String modId, Object... context);
}
