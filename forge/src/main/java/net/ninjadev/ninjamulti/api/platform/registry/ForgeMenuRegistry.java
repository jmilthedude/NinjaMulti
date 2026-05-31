package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.IMenuRegistry;
import net.ninjadev.ninjamulti.api.services.MenuFactory;

import java.util.function.Supplier;

public class ForgeMenuRegistry implements IMenuRegistry {

    private final String modId;
    private final DeferredRegister<MenuType<?>> register;

    public ForgeMenuRegistry(String modId, BusGroup modBusGroup) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.MENU, modId);
        register.register(modBusGroup);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends AbstractContainerMenu> Supplier<MenuType<T>> registerMenuType(
            String name, MenuFactory<T> factory) {
        return (Supplier<MenuType<T>>) (Supplier<?>) register.register(name,
                () -> new MenuType<>(factory::create, FeatureFlags.DEFAULT_FLAGS));
    }
}
