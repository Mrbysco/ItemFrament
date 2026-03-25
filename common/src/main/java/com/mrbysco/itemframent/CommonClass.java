package com.mrbysco.itemframent;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class CommonClass {
	public static void handleSplash(Iterable<MobEffectInstance> effectInstanceList, AbstractThrownPotion thrownPotion) {
		AABB checkBox = thrownPotion.getBoundingBox().inflate(4.0D, 2.0D, 4.0D);
		effectInstanceList.forEach(instance -> {
			if (instance.is(MobEffects.INVISIBILITY)) {
				List<ItemFrame> itemFrames = thrownPotion.level().getEntitiesOfClass(ItemFrame.class, checkBox);
				for (ItemFrame frame : itemFrames) {
					if (!frame.isInvisible())
						frame.setInvisible(true);
				}
			}
		});
	}

	public static void handleWater(AbstractThrownPotion thrownPotion) {
		AABB checkBox = thrownPotion.getBoundingBox().inflate(4.0D, 2.0D, 4.0D);
		List<ItemFrame> itemFrames = thrownPotion.level().getEntitiesOfClass(ItemFrame.class, checkBox);
		for (ItemFrame frame : itemFrames) {
			if (frame.isInvisible())
				frame.setInvisible(false);
		}
	}
}