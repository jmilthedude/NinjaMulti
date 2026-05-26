package net.ninjadev.ninjamulti.api.platform;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ninjadev.ninjamulti.api.services.IRegistrationHelper;

import java.util.function.Supplier;

public class ForgeRegistrationHelper implements IRegistrationHelper {

    private final DeferredRegister<Block> blocks;
    private final DeferredRegister<Item> items;
    private final DeferredRegister<CreativeModeTab> tabs;
    private final DeferredRegister<ParticleType<?>> particles;

    public ForgeRegistrationHelper(String modId, BusGroup modBusGroup) {
        this.blocks = DeferredRegister.create(Registries.BLOCK, modId);
        this.items = DeferredRegister.create(Registries.ITEM, modId);
        this.tabs = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modId);
        this.particles = DeferredRegister.create(Registries.PARTICLE_TYPE, modId);
        blocks.register(modBusGroup);
        items.register(modBusGroup);
        tabs.register(modBusGroup);
        particles.register(modBusGroup);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        RegistryObject<T> obj = blocks.register(name, blockSupplier);
        return obj;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        RegistryObject<T> obj = items.register(name, itemSupplier);
        return obj;
    }

    @Override
    public Supplier<CreativeModeTab> registerCreativeTab(String name, Supplier<CreativeModeTab> tabSupplier) {
        RegistryObject<CreativeModeTab> obj = tabs.register(name, tabSupplier);
        return obj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Supplier<SimpleParticleType> registerSimpleParticleType(String name) {
        RegistryObject<SimpleParticleType> obj = (RegistryObject<SimpleParticleType>) (RegistryObject<?>)
                particles.register(name, () -> new SimpleParticleType(false));
        return obj;
    }
}
