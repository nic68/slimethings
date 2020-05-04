
package net.slimethings.item;

import net.slimethings.procedures.EdibleSlimeFoodEatenProcedure;
import net.slimethings.SlimeThingsElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

@SlimeThingsElements.ModElement.Tag
public class EdibleSlimeItem extends SlimeThingsElements.ModElement {
	@ObjectHolder("slimethings:edible_slime")
	public static final Item block = null;
	public EdibleSlimeItem(SlimeThingsElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64)
					.food((new Food.Builder()).hunger(2).saturation(0.7999999999999999f).setAlwaysEdible().build()));
			setRegistryName("edible_slime");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 20;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.getPosX();
			int y = (int) entity.getPosY();
			int z = (int) entity.getPosZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				EdibleSlimeFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
