package net.marlester.everythingasahat.item.custom;

import com.sun.istack.internal.Nullable;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class WhistleItem extends Item {

    public WhistleItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        assert player != null;
//        List<HorseEntity> horses = world.getEntitiesByClass(HorseEntity.class, player.getBoundingBox().expand(10.0), null);
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.callahorse.whistle.tooltip1"));
        tooltip.add(new TranslatableText("item.callahorse.whistle.tooltip2"));
    }
}
