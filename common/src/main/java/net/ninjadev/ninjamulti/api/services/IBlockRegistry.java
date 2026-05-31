package net.ninjadev.ninjamulti.api.services;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface IBlockRegistry extends IModRegistry {

    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier);

    default ResourceKey<Block> blockKey(String name) {
        return ResourceKey.create(Registries.BLOCK, id(name));
    }
}
