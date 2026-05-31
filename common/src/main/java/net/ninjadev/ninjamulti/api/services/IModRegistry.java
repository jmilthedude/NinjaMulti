package net.ninjadev.ninjamulti.api.services;

import net.minecraft.resources.Identifier;

public interface IModRegistry {

    String getModId();

    default Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(getModId(), name);
    }
}
