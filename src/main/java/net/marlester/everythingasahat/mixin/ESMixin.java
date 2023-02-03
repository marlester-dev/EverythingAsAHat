package net.marlester.everythingasahat.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class) // In 1.18 or 1.17+ it is LivingEntity
public class ESMixin {
    @Inject(at = @At("HEAD"), method = "getPreferredEquipmentSlot", cancellable = true)
    private static void getPreferredEquipmentSlot(ItemStack itemStack, CallbackInfoReturnable<EquipmentSlot> cir) {
        Item item = itemStack.getItem();
        // !(item instanceof SkullItem) does not properly work, so I have to list every skull/head
        if (!(item instanceof ElytraItem) && !(item instanceof ShieldItem) && !(item instanceof ArmorItem) && item != Blocks.CARVED_PUMPKIN.asItem() && item != Items.SKELETON_SKULL && item != Items.WITHER_SKELETON_SKULL && item != Items.CREEPER_HEAD && item != Items.DRAGON_HEAD && item != Items.PLAYER_HEAD && item != Items.ZOMBIE_HEAD) {
            cir.setReturnValue(EquipmentSlot.HEAD);
        }
        // fix for shift+lmb items
        if (Screen.hasShiftDown() && !(item instanceof ElytraItem) && !(item instanceof ShieldItem) && !(item instanceof ArmorItem) && item != Blocks.CARVED_PUMPKIN.asItem() && item != Items.SKELETON_SKULL && item != Items.WITHER_SKELETON_SKULL && item != Items.CREEPER_HEAD && item != Items.DRAGON_HEAD && item != Items.PLAYER_HEAD && item != Items.ZOMBIE_HEAD) {
            cir.setReturnValue(EquipmentSlot.MAINHAND);
        }
    }
}
