package com.mrbysco.itemframent.mixin;

import com.mrbysco.itemframent.CommonClass;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ThrownLingeringPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownLingeringPotion.class)
public class ThrownLingeringPotionMixin {
	@Inject(method = "onHitAsPotion(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/phys/HitResult;)V", at = @At("HEAD"))
	public void itemframent$applySplash(ServerLevel serverLevel, ItemStack stack, HitResult result, CallbackInfo ci) {
		ThrownLingeringPotion potion = (ThrownLingeringPotion) (Object) this;
		PotionContents potioncontents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
		Iterable<MobEffectInstance> effects = potioncontents.getAllEffects();
		CommonClass.handleSplash(effects, potion);
	}
}
