package com.ender.enderiso.setup;

import com.ender.enderiso.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("enderiso") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.ORAX_ORE);
        }
    };

    public void init() {

    }
}
