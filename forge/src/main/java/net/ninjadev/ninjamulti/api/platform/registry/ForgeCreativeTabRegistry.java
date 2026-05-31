package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.ICreativeTabRegistry;

import java.util.function.Supplier;

public class ForgeCreativeTabRegistry implements ICreativeTabRegistry {

    private final String modId;
    private final DeferredRegister<CreativeModeTab> register;

    public ForgeCreativeTabRegistry(String modId, BusGroup modBusGroup) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modId);
        register.register(modBusGroup);
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
