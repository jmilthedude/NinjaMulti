package net.ninjadev.ninjamulti.api.platform;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.IRegistrationHelper;

import java.util.function.Supplier;

public class NeoForgeRegistrationHelper implements IRegistrationHelper {

    private final String modId;
    private final DeferredRegister<Block> blocks;
    private final DeferredRegister<Item> items;
    private final DeferredRegister<CreativeModeTab> tabs;
    private final DeferredRegister<ParticleType<?>> particles;

    public NeoForgeRegistrationHelper(String modId, IEventBus modBus) {
        this.modId = modId;
        this.blocks = DeferredRegister.create(Registries.BLOCK, modId);
        this.items = DeferredRegister.create(Registries.ITEM, modId);
        this.tabs = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modId);
        this.particles = DeferredRegister.create(Registries.PARTICLE_TYPE, modId);
        blocks.register(modBus);
        items.register(modBus);
        tabs.register(modBus);
        particles.register(modBus);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        DeferredHolder<Block, T> holder = blocks.register(name, blockSupplier);
        return holder;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        DeferredHolder<Item, T> holder = items.register(name, itemSupplier);
        return holder;
    }

    @Override
    public Supplier<CreativeModeTab> registerCreativeTab(String name, Supplier<CreativeModeTab> tabSupplier) {
        DeferredHolder<CreativeModeTab, CreativeModeTab> holder = tabs.register(name, tabSupplier);
        return holder;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Supplier<SimpleParticleType> registerSimpleParticleType(String name) {
        DeferredHolder<ParticleType<?>, SimpleParticleType> holder =
                (DeferredHolder<ParticleType<?>, SimpleParticleType>) (DeferredHolder<?, ?>)
                        particles.register(name, () -> new SimpleParticleType(false));
        return holder;
    }
}
