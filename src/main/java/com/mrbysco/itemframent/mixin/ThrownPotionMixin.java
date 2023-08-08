package com.mrbysco.itemframent.mixin;

import com.mrbysco.itemframent.ItemFrament;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ThrownPotion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(ThrownPotion.class)
public class ThrownPotionMixin {
	@Inject(method = "applySplash(Ljava/util/List;Lnet/minecraft/world/entity/Entity;)V", at = @At("HEAD"))
	public void applySplash(List<MobEffectInstance> effectInstanceList, @Nullable Entity entity, CallbackInfo ci) {
		ThrownPotion potion = (ThrownPotion) (Object) this;
		ItemFrament.handleSplash(effectInstanceList, potion);
	}

	@Inject(method = "applyWater()V", at = @At("HEAD"))
	private void applyWater(CallbackInfo ci) {
		ThrownPotion potion = (ThrownPotion) (Object) this;
		ItemFrament.handleWater(potion);
	}
}
