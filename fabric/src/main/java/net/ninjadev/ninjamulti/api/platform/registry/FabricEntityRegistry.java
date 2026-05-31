package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.ninjadev.ninjamulti.api.services.IEntityRegistry;

import java.util.function.Supplier;

public class FabricEntityRegistry implements IEntityRegistry {

    private final String modId;

    public FabricEntityRegistry(String modId) {
        this.modId = modId;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntityType(String name, EntityType.Builder<T> builder) {
        EntityType<T> entityType = builder.build(entityTypeKey(name));
        Registry.register(BuiltInRegistries.ENTITY_TYPE, id(name), entityType);
        return () -> entityType;
    }
}
