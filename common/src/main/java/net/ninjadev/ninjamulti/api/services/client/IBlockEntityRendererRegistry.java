package net.ninjadev.ninjamulti.api.services.client;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public interface IBlockEntityRendererRegistry {

    <T extends BlockEntity, S extends BlockEntityRenderState> void registerBlockEntityRenderer(
            Supplier<? extends BlockEntityType<? extends T>> type,
            BlockEntityRendererProvider<T, S> provider);
}
