package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.IItemRegistry;

import java.util.function.Supplier;

public class ForgeItemRegistry implements IItemRegistry {

    private final String modId;
    private final DeferredRegister<Item> register;

    public ForgeItemRegistry(String modId, BusGroup modBusGroup) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.ITEM, modId);
        register.register(modBusGroup);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return register.register(name, itemSupplier);
    }
}
