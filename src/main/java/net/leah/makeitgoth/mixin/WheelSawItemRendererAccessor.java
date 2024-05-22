package net.leah.makeitgoth.mixin;

import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemRenderer.class)
public interface WheelSawItemRendererAccessor {
    @Accessor("models")
    ItemModels mccourse$getModels();
}