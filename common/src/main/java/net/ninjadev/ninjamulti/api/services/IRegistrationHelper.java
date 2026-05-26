package net.ninjadev.ninjamulti.api.services;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface IRegistrationHelper {
    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier);
    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier);
    Supplier<CreativeModeTab> registerCreativeTab(String name, Supplier<CreativeModeTab> tabSupplier);
    Supplier<SimpleParticleType> registerSimpleParticleType(String name);
}
