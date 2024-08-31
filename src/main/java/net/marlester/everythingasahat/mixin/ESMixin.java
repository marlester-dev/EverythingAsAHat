package net.marlester.everythingasahat.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net/minecraft/screen/slot/ArmorSlot"})
public class ESMixin {
    EquipmentSlot field_51623;
    @Inject(method = "canInsert(Lnet/minecraft/item/ItemStack;)Z", at = @At("RETURN"), cancellable = true)
    public void allowItemEquipping(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (field_51623 == EquipmentSlot.HEAD) {
            cir.setReturnValue(true);
        }
    }
}