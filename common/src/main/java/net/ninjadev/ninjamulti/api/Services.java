package net.ninjadev.ninjamulti.api;

import net.ninjadev.ninjamulti.api.services.IPlatformHelper;
import net.ninjadev.ninjamulti.api.services.IRegistrar;
import net.ninjadev.ninjamulti.api.services.IRegistrarFactory;
import net.ninjadev.ninjamulti.api.services.client.IClientRegistrar;
import net.ninjadev.ninjamulti.api.services.client.IClientRegistrarFactory;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    private static final IRegistrarFactory REGISTRAR_FACTORY = load(IRegistrarFactory.class);

    public static IRegistrar createRegistrar(String modId, Object... context) {
        return REGISTRAR_FACTORY.create(modId, context);
    }

    public static IClientRegistrar createClientRegistrar(Object... context) {
        IClientRegistrarFactory factory = load(IClientRegistrarFactory.class);
        return factory.create(context);
    }

    public static <T> T load(Class<T> clazz) {
        Iterator<T> iterator = ServiceLoader.load(clazz).iterator();
        while (iterator.hasNext()) {
            try {
                T service = iterator.next();
                Constants.LOG.debug("Loaded {} for service {}", service, clazz);
                return service;
            } catch (ServiceConfigurationError e) {
                Constants.LOG.debug("Skipping unavailable service provider for {}", clazz);
            }
        }
        throw new NullPointerException("Failed to load service for " + clazz.getName());
    }
}
