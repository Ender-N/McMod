package com.ender.enderiso.items.tools;

import com.ender.enderiso.Enderiso;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;

public class LazzerGun extends Item {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public LazzerGun() {
        super(new Item.Properties()
                .group(Enderiso.setup.itemGroup)
                .maxStackSize(1)
                .defaultMaxDamage(255)
        );
        setRegistryName("lazzer_gun");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        Vec3d aim = playerIn.getLookVec();
        ArrowEntity arrow = new ArrowEntity(worldIn,1, 1,1);

        arrow.setPosition(playerIn.chasingPosX + aim.x * 1.5,(playerIn.chasingPosY + aim.y * 1.5) + 1.5, playerIn.chasingPosZ +aim.z * 1.5);
        arrow.addVelocity(aim.x * 1.5, aim.y * 1.5, aim.z * 1.5);
        worldIn.addEntity(arrow);

        item.damageItem(1, playerIn, playerEntity -> {});
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, item);
    }
}
