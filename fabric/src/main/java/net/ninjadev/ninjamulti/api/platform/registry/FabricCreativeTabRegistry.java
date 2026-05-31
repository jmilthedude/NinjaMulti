package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.ninjadev.ninjamulti.api.services.ICreativeTabRegistry;

import java.util.function.Supplier;

public class FabricCreativeTabRegistry implements ICreativeTabRegistry {

    private final String modId;

    public FabricCreativeTabRegistry(String modId) {
        this.modId = modId;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public Supplier<CreativeModeTab> registerCreativeTab(String name, Supplier<CreativeModeTab> tabSupplier) {
        CreativeModeTab tab = tabSupplier.get();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, id(name), tab);
        return () -> tab;
    }
}
