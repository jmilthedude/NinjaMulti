package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.ninjadev.ninjamulti.api.services.BlockEntityFactory;
import net.ninjadev.ninjamulti.api.services.IBlockEntityRegistry;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FabricBlockEntityRegistry implements IBlockEntityRegistry {

    private final String modId;

    public FabricBlockEntityRegistry(String modId) {
        this.modId = modId;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(
            String name,
            BlockEntityFactory<T> factory,
            List<Supplier<? extends Block>> validBlocks) {
        Set<Block> blocks = validBlocks.stream()
                .map(Supplier::get)
                .collect(Collectors.toSet());
        BlockEntityType<T> type = new BlockEntityType<>(factory::create, blocks);
        Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id(name), type);
        return () -> type;
    }
}
