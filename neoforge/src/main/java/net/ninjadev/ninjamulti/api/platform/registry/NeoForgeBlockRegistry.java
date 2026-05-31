package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.IBlockRegistry;

import java.util.function.Supplier;

public class NeoForgeBlockRegistry implements IBlockRegistry {

    private final String modId;
    private final DeferredRegister<Block> register;

    public NeoForgeBlockRegistry(String modId, IEventBus modBus) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.BLOCK, modId);
        register.register(modBus);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return register.register(name, blockSupplier);
    }
}
