package net.leah.makeitgoth.mixin;

import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemRenderer.class)
public interface MakeItGothItemRendererAccessor {
    @Accessor("models")
    ItemModels makeitgoth$getModels(); // (ender) I m going to leave this here for now even if its not used
}