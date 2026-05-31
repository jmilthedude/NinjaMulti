package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.ninjadev.ninjamulti.api.services.IBlockRegistry;

import java.util.function.Supplier;

public class FabricBlockRegistry implements IBlockRegistry {

    private final String modId;

    public FabricBlockRegistry(String modId) {
        this.modId = modId;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        T block = blockSupplier.get();
        Registry.register(BuiltInRegistries.BLOCK, id(name), block);
        return () -> block;
    }
}
