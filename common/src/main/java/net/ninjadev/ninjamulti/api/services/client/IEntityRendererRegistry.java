package net.ninjadev.ninjamulti.api.services.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public interface IEntityRendererRegistry {

    <T extends Entity> void registerEntityRenderer(
            Supplier<? extends EntityType<? extends T>> type,
            EntityRendererProvider<T> provider);
}
