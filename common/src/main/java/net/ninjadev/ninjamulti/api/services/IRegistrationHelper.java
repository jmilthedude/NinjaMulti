package net.ninjadev.ninjamulti.api.services;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public interface IRegistrationHelper {

    String getModId();

    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier);
    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier);
    Supplier<CreativeModeTab> registerCreativeTab(String name, Supplier<CreativeModeTab> tabSupplier);
    Supplier<SimpleParticleType> registerSimpleParticleType(String name);

    default ResourceKey<Item> itemKey(String name) {
        return ResourceKey.create(Registries.ITEM,
                Identifier.fromNamespaceAndPath(getModId(), name));
    }

    default ResourceKey<Block> blockKey(String name) {
        return ResourceKey.create(Registries.BLOCK,
                Identifier.fromNamespaceAndPath(getModId(), name));
    }

    default Supplier<Item> registerSimpleItem(String name, Item.Properties props) {
        return registerItem(name, () -> new Item(props.setId(itemKey(name))));
    }

    default Supplier<Block> registerBlockWithItem(String name, BlockBehaviour.Properties blockProps) {
        Supplier<Block> block = registerBlock(name,
                () -> new Block(blockProps.setId(blockKey(name))));
        registerItem(name,
                () -> new BlockItem(block.get(), new Item.Properties().setId(itemKey(name))));
        return block;
    }

    default <T extends Block> Supplier<T> registerBlockWithItem(String name, BlockBehaviour.Properties blockProps,
            Function<BlockBehaviour.Properties, T> blockFactory) {
        Supplier<T> block = registerBlock(name,
                () -> blockFactory.apply(blockProps.setId(blockKey(name))));
        registerItem(name,
                () -> new BlockItem(block.get(), new Item.Properties().setId(itemKey(name))));
        return block;
    }
}
