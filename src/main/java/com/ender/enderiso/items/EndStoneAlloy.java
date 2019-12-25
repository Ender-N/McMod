package com.ender.enderiso.items;

import com.ender.enderiso.Enderiso;
import net.minecraft.item.Item;

public class EndStoneAlloy extends Item {

    public EndStoneAlloy() {
        super(new Properties()
                        .group(Enderiso.setup.itemGroup)
        );
        setRegistryName("end_stone_shards");
    }
}
