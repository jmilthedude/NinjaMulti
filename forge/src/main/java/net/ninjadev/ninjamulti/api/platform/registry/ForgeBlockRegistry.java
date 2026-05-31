package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.IBlockRegistry;

import java.util.function.Supplier;

public class ForgeBlockRegistry implements IBlockRegistry {

    private final String modId;
    private final DeferredRegister<Block> register;

    public ForgeBlockRegistry(String modId, BusGroup modBusGroup) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.BLOCK, modId);
        register.register(modBusGroup);
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
