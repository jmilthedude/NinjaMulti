package net.ninjadev.ninjamulti.api.platform;

import net.neoforged.bus.api.IEventBus;
import net.ninjadev.ninjamulti.api.platform.registry.*;
import net.ninjadev.ninjamulti.api.services.*;

public class NeoForgeRegistrar implements IRegistrar {

    private final String modId;
    private final NeoForgeBlockRegistry blocks;
    private final NeoForgeItemRegistry items;
    private final NeoForgeCreativeTabRegistry creativeTabs;
    private final NeoForgeParticleRegistry particles;
    private final NeoForgeEntityRegistry entities;
    private final NeoForgeBlockEntityRegistry blockEntities;
    private final NeoForgeSoundRegistry sounds;
    private final NeoForgeMenuRegistry menus;

    public NeoForgeRegistrar(String modId, IEventBus modBus) {
        this.modId = modId;
        this.blocks = new NeoForgeBlockRegistry(modId, modBus);
        this.items = new NeoForgeItemRegistry(modId, modBus);
        this.creativeTabs = new NeoForgeCreativeTabRegistry(modId, modBus);
        this.particles = new NeoForgeParticleRegistry(modId, modBus);
        this.entities = new NeoForgeEntityRegistry(modId, modBus);
        this.blockEntities = new NeoForgeBlockEntityRegistry(modId, modBus);
        this.sounds = new NeoForgeSoundRegistry(modId, modBus);
        this.menus = new NeoForgeMenuRegistry(modId, modBus);
    }

    @Override public String getModId() { return modId; }
    @Override public IBlockRegistry blocks() { return blocks; }
    @Override public IItemRegistry items() { return items; }
    @Override public ICreativeTabRegistry creativeTabs() { return creativeTabs; }
    @Override public IParticleRegistry particles() { return particles; }
    @Override public IEntityRegistry entities() { return entities; }
    @Override public IBlockEntityRegistry blockEntities() { return blockEntities; }
    @Override public ISoundRegistry sounds() { return sounds; }
    @Override public IMenuRegistry menus() { return menus; }
}
