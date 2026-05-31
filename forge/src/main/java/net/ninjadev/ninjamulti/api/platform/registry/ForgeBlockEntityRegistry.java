package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ninjadev.ninjamulti.api.services.BlockEntityFactory;
import net.ninjadev.ninjamulti.api.services.IBlockEntityRegistry;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ForgeBlockEntityRegistry implements IBlockEntityRegistry {

    private final String modId;
    private final DeferredRegister<BlockEntityType<?>> register;

    public ForgeBlockEntityRegistry(String modId, BusGroup modBusGroup) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, modId);
        register.register(modBusGroup);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(
            String name,
            BlockEntityFactory<T> factory,
            List<Supplier<? extends Block>> validBlocks) {
        RegistryObject<BlockEntityType<T>> obj = (RegistryObject<BlockEntityType<T>>) (RegistryObject<?>)
                register.register(name, () -> {
                    Set<Block> blocks = validBlocks.stream()
                            .map(Supplier::get)
                            .collect(Collectors.toSet());
                    return new BlockEntityType<>(factory::create, blocks);
                });
        return obj;
    }
}
