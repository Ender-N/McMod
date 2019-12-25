package com.ender.enderiso.items;

import com.ender.enderiso.Enderiso;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class EndStoneShards extends Item {

    public EndStoneShards() {
        super(new Properties()
                        .group(Enderiso.setup.itemGroup)
        );
        setRegistryName("end_stone_shards");
    }
}
