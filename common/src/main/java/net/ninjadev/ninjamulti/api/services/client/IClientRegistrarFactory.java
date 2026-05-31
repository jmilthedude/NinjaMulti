package net.ninjadev.ninjamulti.api.services.client;

public interface IClientRegistrarFactory {

    IClientRegistrar create(Object... context);
}
