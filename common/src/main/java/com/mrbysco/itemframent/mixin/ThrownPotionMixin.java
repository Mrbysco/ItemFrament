package com.mrbysco.itemframent.mixin;

import com.mrbysco.itemframent.CommonClass;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.projectile.AbstractThrownPotion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractThrownPotion.class)
public class ThrownPotionMixin {

	@Inject(method = "onHitAsWater(Lnet/minecraft/server/level/ServerLevel;)V", at = @At("HEAD"))
	private void itemframent$onHitAsWater(ServerLevel serverLevel, CallbackInfo ci) {
		AbstractThrownPotion potion = (AbstractThrownPotion) (Object) this;
		CommonClass.handleWater(potion);
	}
}
