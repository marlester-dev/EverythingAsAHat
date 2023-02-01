package net.marlester.everythingasahat.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.marlester.everythingasahat.CallAHorse;
import net.marlester.everythingasahat.item.custom.WhistleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item WHISTLE = registerItem("whistle",
            new WhistleItem(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {

        String horsebind = "Horse binded to this whistle";


        return Registry.register(Registry.ITEM, new Identifier(CallAHorse.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CallAHorse.LOGGER.info("Registering Mod Items for " + CallAHorse.MOD_ID);
    }

}
