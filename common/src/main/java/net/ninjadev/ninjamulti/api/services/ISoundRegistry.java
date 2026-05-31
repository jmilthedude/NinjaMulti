package net.ninjadev.ninjamulti.api.services;

import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public interface ISoundRegistry extends IModRegistry {

    Supplier<SoundEvent> registerSoundEvent(String name);

    default Supplier<SoundEvent> registerFixedRangeSoundEvent(String name, float range) {
        return registerSoundEvent(name, range);
    }

    Supplier<SoundEvent> registerSoundEvent(String name, float fixedRange);
}
