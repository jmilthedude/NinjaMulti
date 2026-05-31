package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ninjadev.ninjamulti.api.services.IEntityRegistry;

import java.util.function.Supplier;

public class ForgeEntityRegistry implements IEntityRegistry {

    private final String modId;
    private final DeferredRegister<EntityType<?>> register;

    public ForgeEntityRegistry(String modId, BusGroup modBusGroup) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.ENTITY_TYPE, modId);
        register.register(modBusGroup);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntityType(String name, EntityType.Builder<T> builder) {
        RegistryObject<EntityType<T>> obj = (RegistryObject<EntityType<T>>) (RegistryObject<?>)
                register.register(name, () -> builder.build(entityTypeKey(name)));
        return obj;
    }
}
