package com.ender.enderiso.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientPoxy implements IProxy {

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}