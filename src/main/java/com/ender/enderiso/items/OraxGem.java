package com.ender.enderiso.items;

import com.ender.enderiso.Enderiso;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class OraxGem extends Item {

    public OraxGem() {
        super(new Item.Properties()
                        .group(Enderiso.setup.itemGroup)
                        .rarity(Rarity.UNCOMMON)
        );
        setRegistryName("orax_gem");
    }
}
