package net.ninjadev.ninjamulti.api.services;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public interface IEntityRegistry extends IModRegistry {

    <T extends Entity> Supplier<EntityType<T>> registerEntityType(String name, EntityType.Builder<T> builder);

    default ResourceKey<EntityType<?>> entityTypeKey(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, id(name));
    }
}
