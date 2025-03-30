package com.mrbysco.itemframent.mixin;

import com.mrbysco.itemframent.CommonClass;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ThrownPotion;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownPotion.class)
public class ThrownPotionMixin {
	@Inject(method = "applySplash(Lnet/minecraft/server/level/ServerLevel;Ljava/lang/Iterable;Lnet/minecraft/world/entity/Entity;)V", at = @At("HEAD"))
	public void itemframent$applySplash(ServerLevel serverLevel, Iterable<MobEffectInstance> effectInstanceList, @Nullable Entity entity, CallbackInfo ci) {
		ThrownPotion potion = (ThrownPotion) (Object) this;
		CommonClass.handleSplash(effectInstanceList, potion);
	}

	@Inject(method = "applyWater(Lnet/minecraft/server/level/ServerLevel;)V", at = @At("HEAD"))
	private void itemframent$applyWater(ServerLevel serverLevel, CallbackInfo ci) {
		ThrownPotion potion = (ThrownPotion) (Object) this;
		CommonClass.handleWater(potion);
	}
}
