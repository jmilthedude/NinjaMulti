package net.ninjadev.ninjamulti.api.services;

import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

public interface IParticleRegistry extends IModRegistry {

    Supplier<SimpleParticleType> registerSimpleParticleType(String name);
}
