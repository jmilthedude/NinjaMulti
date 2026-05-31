package net.ninjadev.ninjamulti.api.services;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface IItemRegistry extends IModRegistry {

    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier);

    default ResourceKey<Item> itemKey(String name) {
        return ResourceKey.create(Registries.ITEM, id(name));
    }

    default Supplier<Item> registerSimpleItem(String name, Item.Properties props) {
        return registerItem(name, () -> new Item(props.setId(itemKey(name))));
    }
}
