package net.ninjadev.ninjamulti.api.platform;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.ninjadev.ninjamulti.api.services.IRegistrationHelper;

import java.util.function.Supplier;

public class FabricRegistrationHelper implements IRegistrationHelper {

    private final String modId;

    public FabricRegistrationHelper(String modId) {
        this.modId = modId;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        T block = blockSupplier.get();
        Registry.register(BuiltInRegistries.BLOCK,
                Identifier.fromNamespaceAndPath(modId, name), block);
        return () -> block;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        T item = itemSupplier.get();
        Registry.register(BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(modId, name), item);
        return () -> item;
    }

    @Override
    public Supplier<CreativeModeTab> registerCreativeTab(String name, Supplier<CreativeModeTab> tabSupplier) {
        CreativeModeTab tab = tabSupplier.get();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                Identifier.fromNamespaceAndPath(modId, name), tab);
        return () -> tab;
    }

    @Override
    public Supplier<SimpleParticleType> registerSimpleParticleType(String name) {
        SimpleParticleType particle = FabricParticleTypes.simple();
        Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                Identifier.fromNamespaceAndPath(modId, name), particle);
        return () -> particle;
    }
}
