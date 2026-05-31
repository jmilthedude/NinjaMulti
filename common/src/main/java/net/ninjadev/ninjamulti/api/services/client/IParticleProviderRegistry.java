package net.ninjadev.ninjamulti.api.services.client;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import java.util.function.Supplier;

public interface IParticleProviderRegistry {

    <T extends ParticleOptions> void registerSpriteSet(
            Supplier<? extends ParticleType<T>> type,
            SpriteParticleFactory<T> factory);
}
