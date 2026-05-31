package net.ninjadev.ninjamulti.api.platform;

import net.ninjadev.ninjamulti.api.platform.registry.*;
import net.ninjadev.ninjamulti.api.services.*;

public class FabricRegistrar implements IRegistrar {

    private final String modId;
    private final FabricBlockRegistry blocks;
    private final FabricItemRegistry items;
    private final FabricCreativeTabRegistry creativeTabs;
    private final FabricParticleRegistry particles;
    private final FabricEntityRegistry entities;
    private final FabricBlockEntityRegistry blockEntities;
    private final FabricSoundRegistry sounds;
    private final FabricMenuRegistry menus;

    public FabricRegistrar(String modId) {
        this.modId = modId;
        this.blocks = new FabricBlockRegistry(modId);
        this.items = new FabricItemRegistry(modId);
        this.creativeTabs = new FabricCreativeTabRegistry(modId);
        this.particles = new FabricParticleRegistry(modId);
        this.entities = new FabricEntityRegistry(modId);
        this.blockEntities = new FabricBlockEntityRegistry(modId);
        this.sounds = new FabricSoundRegistry(modId);
        this.menus = new FabricMenuRegistry(modId);
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
