package net.ninjadev.ninjamulti.api.services;

import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

public interface ICreativeTabRegistry extends IModRegistry {

    Supplier<CreativeModeTab> registerCreativeTab(String name, Supplier<CreativeModeTab> tabSupplier);
}
