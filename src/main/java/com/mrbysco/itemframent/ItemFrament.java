package com.mrbysco.itemframent;

import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.phys.AABB;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

import java.util.List;

@Mod(ItemFrament.MOD_ID)
public class ItemFrament {
	public static final String MOD_ID = "itemframent";
	private static final Logger LOGGER = LogUtils.getLogger();

	public ItemFrament() {

	}

	public static void handleSplash(List<MobEffectInstance> effectInstanceList, ThrownPotion thrownPotion) {
		boolean invisibility = effectInstanceList.stream().anyMatch(instance -> instance.getEffect() == MobEffects.INVISIBILITY);
		if (invisibility) {
			List<ItemFrame> itemFrames = getFrames(thrownPotion);
			for (ItemFrame frame : itemFrames) {
				if (!frame.isInvisible())
					frame.setInvisible(true);
			}
		}
	}

	public static void handleWater(ThrownPotion thrownPotion) {
		List<ItemFrame> itemFrames = getFrames(thrownPotion);
		for (ItemFrame frame : itemFrames) {
			if (frame.isInvisible())
				frame.setInvisible(false);
		}
	}

	private static List<ItemFrame> getFrames(ThrownPotion thrownPotion) {
		AABB checkBox = thrownPotion.getBoundingBox().inflate(4.0D, 2.0D, 4.0D);
		return thrownPotion.level().getEntitiesOfClass(ItemFrame.class, checkBox);
	}
}
