package net.ninjadev.ninjamulti.api.services;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;
import java.util.function.Supplier;

public interface IRegistrar extends IModRegistry {

    IBlockRegistry blocks();
    IItemRegistry items();
    ICreativeTabRegistry creativeTabs();
    IParticleRegistry particles();
    IEntityRegistry entities();
    IBlockEntityRegistry blockEntities();
    ISoundRegistry sounds();
    IMenuRegistry menus();

    default Supplier<Block> registerBlockWithItem(String name, BlockBehaviour.Properties blockProps) {
        Supplier<Block> block = blocks().registerBlock(name,
                () -> new Block(blockProps.setId(blocks().blockKey(name))));
        items().registerItem(name,
                () -> new BlockItem(block.get(), new Item.Properties().setId(items().itemKey(name))));
        return block;
    }

    default <T extends Block> Supplier<T> registerBlockWithItem(String name, BlockBehaviour.Properties blockProps,
            Function<BlockBehaviour.Properties, T> blockFactory) {
        Supplier<T> block = blocks().registerBlock(name,
                () -> blockFactory.apply(blockProps.setId(blocks().blockKey(name))));
        items().registerItem(name,
                () -> new BlockItem(block.get(), new Item.Properties().setId(items().itemKey(name))));
        return block;
    }
}
