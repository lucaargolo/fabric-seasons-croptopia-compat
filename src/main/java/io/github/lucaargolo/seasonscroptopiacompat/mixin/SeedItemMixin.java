package io.github.lucaargolo.seasonscroptopiacompat.mixin;

import com.epherical.croptopia.items.SeedItem;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SeedItem.class)
public class SeedItemMixin extends AliasedBlockItem {

    public SeedItemMixin(Block block, Settings settings) {
        super(block, settings);
    }

    @Inject(at = @At("HEAD"), method = "appendTooltip")
    public void fixCroptopiaTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        super.appendTooltip(stack, world, tooltip, context);
    }

}
