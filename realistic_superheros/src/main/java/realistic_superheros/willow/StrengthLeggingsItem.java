package realistic_superheros.willow;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class StrengthLeggingsItem extends DescribedItem {
    public StrengthLeggingsItem(Item.Properties properties) {
        super(properties, "Grants Strength III while equipped");
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        if (slot == EquipmentSlot.LEGS && entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 40, 2, false, false, true));
        }
        super.inventoryTick(stack, level, entity, slot);
    }
}