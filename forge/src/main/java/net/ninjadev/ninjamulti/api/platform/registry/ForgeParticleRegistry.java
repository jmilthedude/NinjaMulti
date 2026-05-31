package net.ninjadev.ninjamulti.api.platform.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ninjadev.ninjamulti.api.services.IParticleRegistry;

import java.util.function.Supplier;

public class ForgeParticleRegistry implements IParticleRegistry {

    private final String modId;
    private final DeferredRegister<ParticleType<?>> register;

    public ForgeParticleRegistry(String modId, BusGroup modBusGroup) {
        this.modId = modId;
        this.register = DeferredRegister.create(Registries.PARTICLE_TYPE, modId);
        register.register(modBusGroup);
    }

    @Override
    public String getModId() {
        return modId;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Supplier<SimpleParticleType> registerSimpleParticleType(String name) {
        RegistryObject<SimpleParticleType> obj = (RegistryObject<SimpleParticleType>) (RegistryObject<?>)
                register.register(name, () -> new SimpleParticleType(false));
        return obj;
    }
}
