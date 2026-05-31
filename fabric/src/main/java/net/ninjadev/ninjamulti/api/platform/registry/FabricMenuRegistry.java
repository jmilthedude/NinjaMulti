package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.ninjadev.ninjamulti.api.services.IMenuRegistry;
import net.ninjadev.ninjamulti.api.services.MenuFactory;

import java.util.function.Supplier;

public class FabricMenuRegistry implements IMenuRegistry {

    private final String modId;

    public FabricMenuRegistry(String modId) {
        this.modId = modId;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends AbstractContainerMenu> Supplier<MenuType<T>> registerMenuType(
            String name, MenuFactory<T> factory) {
        MenuType<T> menuType = new MenuType<>(factory::create, FeatureFlags.DEFAULT_FLAGS);
        Registry.register(BuiltInRegistries.MENU, id(name), menuType);
        return () -> menuType;
    }
}
