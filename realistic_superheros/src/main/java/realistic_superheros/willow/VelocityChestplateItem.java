package realistic_superheros.willow;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class VelocityChestplateItem extends DescribedItem {
    private static final DustParticleOptions WHITE_BORDER_PARTICLE = new DustParticleOptions(0xFFFFFF, 1.45F);
    private final DustParticleOptions streakParticle;
    private final int speedAmplifier;

    public VelocityChestplateItem(Item.Properties properties, TrailColor color) {
        super(properties, "Speed " + (color.speedAmplifier() + 1) + " and a colored particle trail");
        this.streakParticle = new DustParticleOptions(color.particleColor(), 1.25F);
        this.speedAmplifier = color.speedAmplifier();
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        if (slot == EquipmentSlot.CHEST && entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.SPEED, 40, speedAmplifier, false, false, true));

            level.sendParticles(
                WHITE_BORDER_PARTICLE,
                player.getX(),
                player.getY() + 0.5,
                player.getZ(),
                3, 0.24, 0.24, 0.24, 0.02
            );
            level.sendParticles(
                streakParticle,
                player.getX(),
                player.getY() + 0.5,
                player.getZ(),
                12, 0.18, 0.18, 0.18, 0.01
            );
        }
        super.inventoryTick(stack, level, entity, slot);
    }
}
