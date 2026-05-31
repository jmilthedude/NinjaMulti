package net.ninjadev.ninjamulti.api.services.client;

import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;

@FunctionalInterface
public interface SpriteParticleFactory<T extends ParticleOptions> {

    ParticleProvider<T> create(SpriteSet spriteSet);
}
