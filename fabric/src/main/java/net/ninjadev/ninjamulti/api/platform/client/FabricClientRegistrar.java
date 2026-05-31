package net.ninjadev.ninjamulti.api.platform.client;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.ninjadev.ninjamulti.api.services.client.*;

import java.util.function.Supplier;

public class FabricClientRegistrar implements IClientRegistrar,
        IEntityRendererRegistry, IBlockEntityRendererRegistry,
        IParticleProviderRegistry, IMenuScreenRegistry {

    @Override public IEntityRendererRegistry entityRenderers() { return this; }
    @Override public IBlockEntityRendererRegistry blockEntityRenderers() { return this; }
    @Override public IParticleProviderRegistry particleProviders() { return this; }
    @Override public IMenuScreenRegistry menuScreens() { return this; }

    @Override
    public <T extends Entity> void registerEntityRenderer(
            Supplier<? extends EntityType<? extends T>> type,
            EntityRendererProvider<T> provider) {
        EntityRenderers.register(type.get(), provider);
    }

    @Override
    public <T extends BlockEntity, S extends BlockEntityRenderState> void registerBlockEntityRenderer(
            Supplier<? extends BlockEntityType<? extends T>> type,
            BlockEntityRendererProvider<T, S> provider) {
        BlockEntityRenderers.register(type.get(), provider);
    }

    @Override
    public <T extends ParticleOptions> void registerSpriteSet(
            Supplier<? extends ParticleType<T>> type,
            SpriteParticleFactory<T> factory) {
        ParticleProviderRegistry.getInstance().register(type.get(), factory::create);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> void registerMenuScreen(
            Supplier<? extends MenuType<? extends T>> type,
            ScreenFactory<T, U> factory) {
        // On Fabric, vanilla MenuScreens handles screen registration
        net.minecraft.client.gui.screens.MenuScreens.register(
                (MenuType<T>) type.get(), factory::create);
    }
}
