package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.ICreativeTabRegistry;

import java.util.function.Supplier;

public class NeoForgeCreativeTabRegistry implements ICreativeTabRegistry {

    private final String modId;
    private final DeferredRegister<CreativeModeTab> register;

    public NeoForgeCreativeTabRegistry(String modId, IEventBus modBus) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modId);
        register.register(modBus);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public Supplier<CreativeModeTab> registerCreativeTab(String name, Supplier<CreativeModeTab> tabSupplier) {
        return register.register(name, tabSupplier);
    }
}
