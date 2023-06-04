package net.marlester.everythingasahat;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.TranslatableText;
import org.lwjgl.glfw.GLFW;

public class KeyBindings implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBinding keyBinding1 = KeyBindingHelper.registerKeyBinding(new KeyBinding("everythingasahat.keybinding_1", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_H, "everythingasahat.key.category"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding1.wasPressed()) {
                PlayerEntity player = MinecraftClient.getInstance().player;
                if (!player.getMainHandStack().isEmpty()) {
                    MinecraftClient CLIENT = MinecraftClient.getInstance();

                    final int source = player.getInventory().selectedSlot;
                    final int destination = 5; // helmet slot, I can find all of them on imgur.com/4jLf3l5

                    CLIENT.interactionManager.clickSlot (
                            player.playerScreenHandler.syncId,
                            destination,
                            source,
                            SlotActionType.SWAP,
                            player
                    );
                } else {
                    player.sendMessage(new TranslatableText("everythingasahat.mainhand.is.empty.while.pressing.keybinding1"), false);
                    break;
                }
                player.sendMessage(new TranslatableText("everythingasahat.keybinding1.equipped.item.on.head.successfully"), false);
            }
        });
    }
}