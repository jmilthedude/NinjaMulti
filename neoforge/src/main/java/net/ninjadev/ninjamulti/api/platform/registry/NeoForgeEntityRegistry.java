package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.IEntityRegistry;

import java.util.function.Supplier;

public class NeoForgeEntityRegistry implements IEntityRegistry {

    private final String modId;
    private final DeferredRegister<EntityType<?>> register;

    public NeoForgeEntityRegistry(String modId, IEventBus modBus) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.ENTITY_TYPE, modId);
        register.register(modBus);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntityType(String name, EntityType.Builder<T> builder) {
        DeferredHolder<EntityType<?>, EntityType<T>> holder =
                (DeferredHolder<EntityType<?>, EntityType<T>>) (DeferredHolder<?, ?>)
                        register.register(name, () -> builder.build(entityTypeKey(name)));
        return holder;
    }
}
