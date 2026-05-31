package net.ninjadev.ninjamulti.api.services.client;

public interface IClientRegistrar {

    IEntityRendererRegistry entityRenderers();
    IBlockEntityRendererRegistry blockEntityRenderers();
    IParticleProviderRegistry particleProviders();
    IMenuScreenRegistry menuScreens();
}
