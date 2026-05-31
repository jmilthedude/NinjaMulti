package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.ninjadev.ninjamulti.api.services.IItemRegistry;

import java.util.function.Supplier;

public class FabricItemRegistry implements IItemRegistry {

    private final String modId;

    public FabricItemRegistry(String modId) {
        this.modId = modId;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        T item = itemSupplier.get();
        Registry.register(BuiltInRegistries.ITEM, id(name), item);
        return () -> item;
    }
}
