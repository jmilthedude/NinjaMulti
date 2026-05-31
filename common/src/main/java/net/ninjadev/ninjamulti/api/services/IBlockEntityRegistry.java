package net.ninjadev.ninjamulti.api.services;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;
import java.util.function.Supplier;

public interface IBlockEntityRegistry extends IModRegistry {

    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(
            String name,
            BlockEntityFactory<T> factory,
            List<Supplier<? extends Block>> validBlocks);

    default <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(
            String name,
            BlockEntityFactory<T> factory,
            Supplier<? extends Block> validBlock) {
        return registerBlockEntityType(name, factory, List.of(validBlock));
    }
}
