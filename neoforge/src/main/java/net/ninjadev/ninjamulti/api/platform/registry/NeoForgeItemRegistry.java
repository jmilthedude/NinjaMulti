package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.IItemRegistry;

import java.util.function.Supplier;

public class NeoForgeItemRegistry implements IItemRegistry {

    private final String modId;
    private final DeferredRegister<Item> register;

    public NeoForgeItemRegistry(String modId, IEventBus modBus) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.ITEM, modId);
        register.register(modBus);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return register.register(name, itemSupplier);
    }
}
