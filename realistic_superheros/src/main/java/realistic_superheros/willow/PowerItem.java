package realistic_superheros.willow;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PowerItem extends DescribedItem {
    private final PowerMode mode;
    private final EquipmentSlot equipmentSlot;

    public PowerItem(Item.Properties properties, PowerMode mode, EquipmentSlot equipmentSlot) {
        super(properties, mode.description());
        this.mode = mode;
        this.equipmentSlot = equipmentSlot;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        if (entity instanceof Player player && isActive(player, slot)) {
            applyPower(player);
        }
        super.inventoryTick(stack, level, entity, slot);
    }

    private boolean isActive(Player player, EquipmentSlot slot) {
        if (equipmentSlot != null) {
            return slot == equipmentSlot;
        }
        return slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND;
    }

    private void applyPower(Player player) {
        switch (mode) {
            case NIGHT_VISION -> effect(player, MobEffects.NIGHT_VISION, 0);
            case DEEP_SEA, FINSPRINT -> {
                effect(player, MobEffects.WATER_BREATHING, 0);
                effect(player, MobEffects.DOLPHINS_GRACE, 0);
            }
            case FIREPROOF -> effect(player, MobEffects.FIRE_RESISTANCE, 0);
            case SHADOW, PHASE -> effect(player, MobEffects.INVISIBILITY, 0);
            case HASTE -> effect(player, MobEffects.HASTE, 2);
            case RESISTANCE -> effect(player, MobEffects.RESISTANCE, 1);
            case SKYRUNNER -> {
                effect(player, MobEffects.SPEED, 1);
                effect(player, MobEffects.JUMP_BOOST, 1);
            }
            case THUNDER -> {
                effect(player, MobEffects.STRENGTH, 3);
                effect(player, MobEffects.RESISTANCE, 1);
            }
            case HEALING -> {
                effect(player, MobEffects.REGENERATION, 2);
                effect(player, MobEffects.ABSORPTION, 2);
            }
            case FROSTFALL -> {
                effect(player, MobEffects.SLOW_FALLING, 0);
                effect(player, MobEffects.RESISTANCE, 0);
            }
            case MINING -> effect(player, MobEffects.HASTE, 3);
            case BUILDER -> {
                effect(player, MobEffects.HASTE, 1);
                effect(player, MobEffects.SPEED, 0);
            }
            case TIMEKEEPER -> {
                effect(player, MobEffects.NIGHT_VISION, 0);
                effect(player, MobEffects.SLOW_FALLING, 0);
            }
        }
    }

    private static void effect(Player player, net.minecraft.core.Holder<net.minecraft.world.effect.MobEffect> effect,
        int amplifier) {
        player.addEffect(new MobEffectInstance(effect, 40, amplifier, false, false, true));
    }
}