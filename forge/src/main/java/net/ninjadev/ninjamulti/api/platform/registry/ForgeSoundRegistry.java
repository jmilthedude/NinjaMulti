package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.ISoundRegistry;

import java.util.function.Supplier;

public class ForgeSoundRegistry implements ISoundRegistry {

    private final String modId;
    private final DeferredRegister<SoundEvent> register;

    public ForgeSoundRegistry(String modId, BusGroup modBusGroup) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.SOUND_EVENT, modId);
        register.register(modBusGroup);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public Supplier<SoundEvent> registerSoundEvent(String name) {
        Identifier location = id(name);
        return register.register(name, () -> SoundEvent.createVariableRangeEvent(location));
    }

    @Override
    public Supplier<SoundEvent> registerSoundEvent(String name, float fixedRange) {
        Identifier location = id(name);
        return register.register(name, () -> SoundEvent.createFixedRangeEvent(location, fixedRange));
    }
}
