package net.slimethings.procedures;

import net.slimethings.SlimeThingsElements;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@SlimeThingsElements.ModElement.Tag
public class EdibleSlimeFoodEatenProcedure extends SlimeThingsElements.ModElement {
	public EdibleSlimeFoodEatenProcedure(SlimeThingsElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EdibleSlimeFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 180, (int) 2));
	}
}
