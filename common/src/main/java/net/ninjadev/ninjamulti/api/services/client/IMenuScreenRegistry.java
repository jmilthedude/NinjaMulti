package net.ninjadev.ninjamulti.api.services.client;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public interface IMenuScreenRegistry {

    <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> void registerMenuScreen(
            Supplier<? extends MenuType<? extends T>> type,
            ScreenFactory<T, U> factory);
}
