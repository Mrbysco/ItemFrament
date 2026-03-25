package com.mrbysco.itemframent.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mrbysco.itemframent.CommonClass;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownSplashPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownSplashPotion.class)
public class ThrownSplashPotionMixin {
	@Inject(method = "onHitAsPotion(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/phys/HitResult;)V", at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/phys/AABB;inflate(DDD)Lnet/minecraft/world/phys/AABB;",
			shift = At.Shift.AFTER,
			ordinal = 0))
	public void itemframent$applySplash(ServerLevel serverLevel, ItemStack stack, HitResult result, CallbackInfo ci, @Local Iterable<MobEffectInstance> effects) {
		ThrownSplashPotion potion = (ThrownSplashPotion) (Object) this;
		CommonClass.handleSplash(effects, potion);
	}
}
