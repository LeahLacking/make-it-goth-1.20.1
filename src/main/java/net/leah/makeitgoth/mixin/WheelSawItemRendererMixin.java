package net.leah.makeitgoth.mixin;

import net.leah.makeitgoth.item.ModItems;
import net.leah.makeitgoth.MakeItGoth;
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

@Mixin(ItemRenderer.class)
public abstract class WheelSawItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useWheelSawModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.WHEEL_SAW) && renderMode != ModelTransformationMode.HEAD) {
            return ((WheelSawItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MakeItGoth.MOD_ID, "wheel_saw_3d", "inventory"));
        }
        return value;

    }
}