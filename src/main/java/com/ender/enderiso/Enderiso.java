package com.ender.enderiso;

import com.ender.enderiso.items.EndStoneAlloy;
import com.ender.enderiso.items.EndStoneShards;
import com.ender.enderiso.items.OraxGem;
import com.ender.enderiso.items.tools.LazzerGun;
import com.ender.enderiso.setup.ClientProxy;
import com.ender.enderiso.setup.IProxy;
import com.ender.enderiso.setup.ModSetup;
import com.ender.enderiso.setup.ServerProxy;
import com.ender.enderiso.blocks.ModBlocks;
import com.ender.enderiso.blocks.OraxOre;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("enderiso")
public class Enderiso {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(),() -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public Enderiso() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
/*      // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
*/
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
    }

    /*
        private void doClientStuff(final FMLClientSetupEvent event) {
            // do something that can only be done on the client
            LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        }

        private void enqueueIMC(final InterModEnqueueEvent event) {
            // some example code to dispatch IMC to another mod
            InterModComms.sendTo("enderiso", "helloworld", () -> {
                LOGGER.info("Hello world from the MDK");
                return "Hello world";
            });
        }

        private void processIMC(final InterModProcessEvent event) {
            // some example code to receive and process InterModComms from other mods
            LOGGER.info("Got IMC {}", event.getIMCStream().
                    map(m -> m.getMessageSupplier().get()).
                    collect(Collectors.toList()));
        }
    */
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new OraxOre());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
            event.getRegistry().register(new BlockItem(ModBlocks.ORAX_ORE, properties).setRegistryName("orax_ore"));
            event.getRegistry().register(new OraxGem());
            event.getRegistry().register(new EndStoneShards());
            event.getRegistry().register(new EndStoneAlloy());
            event.getRegistry().register(new LazzerGun());
        }
    }
}
