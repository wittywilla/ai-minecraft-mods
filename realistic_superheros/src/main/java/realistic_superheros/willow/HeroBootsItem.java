package realistic_superheros.willow;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HeroBootsItem extends DescribedItem {
    public HeroBootsItem(Item.Properties properties) {
        super(properties, "Grants Jump Boost IV and Slow Falling while equipped");
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        if (slot == EquipmentSlot.FEET && entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 40, 3, false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0, false, false, true));
        }
        super.inventoryTick(stack, level, entity, slot);
    }
}