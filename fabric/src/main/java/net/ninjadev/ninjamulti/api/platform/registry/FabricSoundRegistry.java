package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.ninjadev.ninjamulti.api.services.ISoundRegistry;

import java.util.function.Supplier;

public class FabricSoundRegistry implements ISoundRegistry {

    private final String modId;

    public FabricSoundRegistry(String modId) {
        this.modId = modId;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public Supplier<SoundEvent> registerSoundEvent(String name) {
        SoundEvent event = SoundEvent.createVariableRangeEvent(id(name));
        Registry.register(BuiltInRegistries.SOUND_EVENT, id(name), event);
        return () -> event;
    }

    @Override
    public Supplier<SoundEvent> registerSoundEvent(String name, float fixedRange) {
        SoundEvent event = SoundEvent.createFixedRangeEvent(id(name), fixedRange);
        Registry.register(BuiltInRegistries.SOUND_EVENT, id(name), event);
        return () -> event;
    }
}
