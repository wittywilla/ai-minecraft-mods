package realistic_superheros.willow;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MasterWeaponItem extends DescribedItem {
    public MasterWeaponItem(Item.Properties properties) {
        super(properties, "Invulnerability, Strength V, Resistance V, Regeneration II and Absorption V while held");
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        if (entity instanceof Player player && (slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND)) {
            player.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 40, 4, false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 40, 4, false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 1, false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 40, 4, false, false, true));
        }
        super.inventoryTick(stack, level, entity, slot);
    }
}