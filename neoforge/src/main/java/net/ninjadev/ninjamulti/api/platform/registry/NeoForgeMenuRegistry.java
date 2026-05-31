package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.IMenuRegistry;
import net.ninjadev.ninjamulti.api.services.MenuFactory;

import java.util.function.Supplier;

public class NeoForgeMenuRegistry implements IMenuRegistry {

    private final String modId;
    private final DeferredRegister<MenuType<?>> register;

    public NeoForgeMenuRegistry(String modId, IEventBus modBus) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.MENU, modId);
        register.register(modBus);
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
