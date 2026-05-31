package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ninjadev.ninjamulti.api.services.IParticleRegistry;

import java.util.function.Supplier;

public class NeoForgeParticleRegistry implements IParticleRegistry {

    private final String modId;
    private final DeferredRegister<ParticleType<?>> register;

    public NeoForgeParticleRegistry(String modId, IEventBus modBus) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.PARTICLE_TYPE, modId);
        register.register(modBus);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Supplier<SimpleParticleType> registerSimpleParticleType(String name) {
        DeferredHolder<ParticleType<?>, SimpleParticleType> holder =
                (DeferredHolder<ParticleType<?>, SimpleParticleType>) (DeferredHolder<?, ?>)
                        register.register(name, () -> new SimpleParticleType(false));
        return holder;
    }
}
