package net.ninjadev.ninjamulti.api.platform;

import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.ninjadev.ninjamulti.api.platform.registry.*;
import net.ninjadev.ninjamulti.api.services.*;

public class ForgeRegistrar implements IRegistrar {

    private final String modId;
    private final ForgeBlockRegistry blocks;
    private final ForgeItemRegistry items;
    private final ForgeCreativeTabRegistry creativeTabs;
    private final ForgeParticleRegistry particles;
    private final ForgeEntityRegistry entities;
    private final ForgeBlockEntityRegistry blockEntities;
    private final ForgeSoundRegistry sounds;
    private final ForgeMenuRegistry menus;

    public ForgeRegistrar(String modId, BusGroup modBusGroup) {
        this.modId = modId;
        this.blocks = new ForgeBlockRegistry(modId, modBusGroup);
        this.items = new ForgeItemRegistry(modId, modBusGroup);
        this.creativeTabs = new ForgeCreativeTabRegistry(modId, modBusGroup);
        this.particles = new ForgeParticleRegistry(modId, modBusGroup);
        this.entities = new ForgeEntityRegistry(modId, modBusGroup);
        this.blockEntities = new ForgeBlockEntityRegistry(modId, modBusGroup);
        this.sounds = new ForgeSoundRegistry(modId, modBusGroup);
        this.menus = new ForgeMenuRegistry(modId, modBusGroup);
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
