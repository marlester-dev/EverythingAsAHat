package net.marlester.everythingasahat.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net/minecraft/screen/PlayerScreenHandler$1"})
public class ESMixin {
    EquipmentSlot field_7834;
    @Inject(method = "canInsert(Lnet/minecraft/item/ItemStack;)Z", at = @At("RETURN"), cancellable = true)
    public void allowItemEquipping(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        Item item = itemStack.getItem();
        if (field_7834 == EquipmentSlot.HEAD && item != Items.ELYTRA && item != Items.SHIELD && !(item instanceof ArmorItem) && item != Blocks.CARVED_PUMPKIN.asItem() && item != Items.SKELETON_SKULL && item != Items.WITHER_SKELETON_SKULL && item != Items.CREEPER_HEAD && item != Items.DRAGON_HEAD && item != Items.PLAYER_HEAD && item != Items.ZOMBIE_HEAD) {
            cir.setReturnValue(true);
        }
    }
}