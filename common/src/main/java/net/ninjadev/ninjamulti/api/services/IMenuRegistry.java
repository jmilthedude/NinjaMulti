package net.ninjadev.ninjamulti.api.services;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public interface IMenuRegistry extends IModRegistry {

    <T extends AbstractContainerMenu> Supplier<MenuType<T>> registerMenuType(
            String name, MenuFactory<T> factory);
}
