package net.ninjadev.ninjamulti.api.platform.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.ninjadev.ninjamulti.api.services.IParticleRegistry;

import java.util.function.Supplier;

public class FabricParticleRegistry implements IParticleRegistry {

    private final String modId;

    public FabricParticleRegistry(String modId) {
        this.modId = modId;
    }

    @Override
    public String getModId() {
        return modId;
    }

    @Override
    public Supplier<SimpleParticleType> registerSimpleParticleType(String name) {
        SimpleParticleType particle = FabricParticleTypes.simple();
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, id(name), particle);
        return () -> particle;
    }
}
