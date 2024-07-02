package net.leah.makeitgoth.mixin;

import net.leah.makeitgoth.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static net.leah.makeitgoth.MakeItGoth.id;

@Mixin(ItemRenderer.class)
public abstract class RifleHalberdItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRifleHalberdModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.RIFLE_HALBERD) && renderMode != ModelTransformationMode.HEAD) {
            return ((RifleHalberdItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(id("rifle_halberd_3d"), "inventory"));
        }
        return value;

    }
}