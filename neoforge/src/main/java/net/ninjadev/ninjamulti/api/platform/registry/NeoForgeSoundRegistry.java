package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.ISoundRegistry;

import java.util.function.Supplier;

public class NeoForgeSoundRegistry implements ISoundRegistry {

    private final String modId;
    private final DeferredRegister<SoundEvent> register;

    public NeoForgeSoundRegistry(String modId, IEventBus modBus) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.SOUND_EVENT, modId);
        register.register(modBus);
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
