package realistic_superheros.willow;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

public class RealisticSuperheros implements ModInitializer {
    public static final String MOD_ID = "realistic_superheros";
    private static final ResourceKey<Item> BLUE_CHESTPLATE_KEY = itemKey("velocity_chestplate_i");
    private static final ResourceKey<Item> YELLOW_CHESTPLATE_KEY = itemKey("velocity_chestplate_ii");
    private static final ResourceKey<Item> RED_CHESTPLATE_KEY = itemKey("velocity_chestplate_v");
    private static final ResourceKey<Item> GREEN_CHESTPLATE_KEY = itemKey("velocity_chestplate_iii");
    private static final ResourceKey<Item> ORANGE_CHESTPLATE_KEY = itemKey("velocity_chestplate_iv");
    private static final ResourceKey<Item> FLIGHT_HELMET_KEY = itemKey("aerial_flight_helmet");
    private static final ResourceKey<Item> STRENGTH_LEGGINGS_KEY = itemKey("titan_strength_leggings");
    private static final ResourceKey<Item> HERO_BOOTS_KEY = itemKey("meteor_jump_boots");
    private static final ResourceKey<Item> MASTER_WEAPON_KEY = itemKey("absolute_power_sword");
    private static final ResourceKey<Item> SOLAR_VISOR_KEY = itemKey("solar_vision_visor");
    private static final ResourceKey<Item> DEEP_SEA_MASK_KEY = itemKey("deep_sea_mask");
    private static final ResourceKey<Item> FLAMEGUARD_CHESTPLATE_KEY = itemKey("flameguard_chestplate");
    private static final ResourceKey<Item> SHADOW_CLOAK_KEY = itemKey("shadow_cloak");
    private static final ResourceKey<Item> KINETIC_BRACERS_KEY = itemKey("kinetic_bracers");
    private static final ResourceKey<Item> GUARDIAN_GREAVES_KEY = itemKey("guardian_greaves");
    private static final ResourceKey<Item> SKYWALKER_BOOTS_KEY = itemKey("skywalker_boots");
    private static final ResourceKey<Item> AQUA_FINS_KEY = itemKey("aqua_fins");
    private static final ResourceKey<Item> THUNDER_HAMMER_KEY = itemKey("thunder_hammer");
    private static final ResourceKey<Item> LIFE_STAFF_KEY = itemKey("life_staff");
    private static final ResourceKey<Item> FROSTFALL_CAPE_KEY = itemKey("frostfall_cape");
    private static final ResourceKey<Item> GRAVITY_PICKAXE_KEY = itemKey("gravity_pickaxe");
    private static final ResourceKey<Item> BUILDER_GAUNTLET_KEY = itemKey("builder_gauntlet");
    private static final ResourceKey<Item> TIMEKEEPER_WATCH_KEY = itemKey("timekeeper_watch");
    private static final ResourceKey<Item> PHASE_COMPASS_KEY = itemKey("phase_compass");

    public static final VelocityChestplateItem BLUE_CHESTPLATE = createChestplate(BLUE_CHESTPLATE_KEY, TrailColor.BLUE);
    public static final VelocityChestplateItem YELLOW_CHESTPLATE = createChestplate(YELLOW_CHESTPLATE_KEY, TrailColor.YELLOW);
    public static final VelocityChestplateItem RED_CHESTPLATE = createChestplate(RED_CHESTPLATE_KEY, TrailColor.RED);
    public static final VelocityChestplateItem GREEN_CHESTPLATE = createChestplate(GREEN_CHESTPLATE_KEY, TrailColor.GREEN);
    public static final VelocityChestplateItem ORANGE_CHESTPLATE = createChestplate(ORANGE_CHESTPLATE_KEY, TrailColor.ORANGE);
    public static final FlightHelmetItem FLIGHT_HELMET = new FlightHelmetItem(
        new Item.Properties().setId(FLIGHT_HELMET_KEY).humanoidArmor(ArmorMaterials.NETHERITE, ArmorType.HELMET)
    );
    public static final StrengthLeggingsItem STRENGTH_LEGGINGS = new StrengthLeggingsItem(
        new Item.Properties().setId(STRENGTH_LEGGINGS_KEY).humanoidArmor(ArmorMaterials.NETHERITE, ArmorType.LEGGINGS)
    );
    public static final HeroBootsItem HERO_BOOTS = new HeroBootsItem(
        new Item.Properties().setId(HERO_BOOTS_KEY).humanoidArmor(ArmorMaterials.NETHERITE, ArmorType.BOOTS)
    );
    public static final MasterWeaponItem MASTER_WEAPON = new MasterWeaponItem(
        new Item.Properties().setId(MASTER_WEAPON_KEY).sword(ToolMaterial.NETHERITE, 20.0F, -2.4F)
    );
    public static final PowerItem SOLAR_VISOR = armorPower(SOLAR_VISOR_KEY, PowerMode.NIGHT_VISION, ArmorType.HELMET);
    public static final PowerItem DEEP_SEA_MASK = armorPower(DEEP_SEA_MASK_KEY, PowerMode.DEEP_SEA, ArmorType.HELMET);
    public static final PowerItem FLAMEGUARD_CHESTPLATE = armorPower(FLAMEGUARD_CHESTPLATE_KEY, PowerMode.FIREPROOF, ArmorType.CHESTPLATE);
    public static final PowerItem SHADOW_CLOAK = armorPower(SHADOW_CLOAK_KEY, PowerMode.SHADOW, ArmorType.CHESTPLATE);
    public static final PowerItem KINETIC_BRACERS = heldPower(KINETIC_BRACERS_KEY, PowerMode.HASTE);
    public static final PowerItem GUARDIAN_GREAVES = armorPower(GUARDIAN_GREAVES_KEY, PowerMode.RESISTANCE, ArmorType.LEGGINGS);
    public static final PowerItem SKYWALKER_BOOTS = armorPower(SKYWALKER_BOOTS_KEY, PowerMode.SKYRUNNER, ArmorType.BOOTS);
    public static final PowerItem AQUA_FINS = armorPower(AQUA_FINS_KEY, PowerMode.FINSPRINT, ArmorType.BOOTS);
    public static final PowerItem THUNDER_HAMMER = heldWeapon(THUNDER_HAMMER_KEY, PowerMode.THUNDER, 12.0F, -2.8F);
    public static final PowerItem LIFE_STAFF = heldWeapon(LIFE_STAFF_KEY, PowerMode.HEALING, 5.0F, -2.8F);
    public static final PowerItem FROSTFALL_CAPE = armorPower(FROSTFALL_CAPE_KEY, PowerMode.FROSTFALL, ArmorType.CHESTPLATE);
    public static final PowerItem GRAVITY_PICKAXE = heldTool(GRAVITY_PICKAXE_KEY, PowerMode.MINING);
    public static final PowerItem BUILDER_GAUNTLET = heldPower(BUILDER_GAUNTLET_KEY, PowerMode.BUILDER);
    public static final PowerItem TIMEKEEPER_WATCH = heldPower(TIMEKEEPER_WATCH_KEY, PowerMode.TIMEKEEPER);
    public static final PowerItem PHASE_COMPASS = heldPower(PHASE_COMPASS_KEY, PowerMode.PHASE);

    @Override
    public void onInitialize() {
        register(BLUE_CHESTPLATE_KEY, BLUE_CHESTPLATE);
        register(YELLOW_CHESTPLATE_KEY, YELLOW_CHESTPLATE);
        register(RED_CHESTPLATE_KEY, RED_CHESTPLATE);
        register(GREEN_CHESTPLATE_KEY, GREEN_CHESTPLATE);
        register(ORANGE_CHESTPLATE_KEY, ORANGE_CHESTPLATE);
        register(FLIGHT_HELMET_KEY, FLIGHT_HELMET);
        register(STRENGTH_LEGGINGS_KEY, STRENGTH_LEGGINGS);
        register(HERO_BOOTS_KEY, HERO_BOOTS);
        register(MASTER_WEAPON_KEY, MASTER_WEAPON);
        register(SOLAR_VISOR_KEY, SOLAR_VISOR);
        register(DEEP_SEA_MASK_KEY, DEEP_SEA_MASK);
        register(FLAMEGUARD_CHESTPLATE_KEY, FLAMEGUARD_CHESTPLATE);
        register(SHADOW_CLOAK_KEY, SHADOW_CLOAK);
        register(KINETIC_BRACERS_KEY, KINETIC_BRACERS);
        register(GUARDIAN_GREAVES_KEY, GUARDIAN_GREAVES);
        register(SKYWALKER_BOOTS_KEY, SKYWALKER_BOOTS);
        register(AQUA_FINS_KEY, AQUA_FINS);
        register(THUNDER_HAMMER_KEY, THUNDER_HAMMER);
        register(LIFE_STAFF_KEY, LIFE_STAFF);
        register(FROSTFALL_CAPE_KEY, FROSTFALL_CAPE);
        register(GRAVITY_PICKAXE_KEY, GRAVITY_PICKAXE);
        register(BUILDER_GAUNTLET_KEY, BUILDER_GAUNTLET);
        register(TIMEKEEPER_WATCH_KEY, TIMEKEEPER_WATCH);
        register(PHASE_COMPASS_KEY, PHASE_COMPASS);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(BLUE_CHESTPLATE);
            output.accept(YELLOW_CHESTPLATE);
            output.accept(RED_CHESTPLATE);
            output.accept(GREEN_CHESTPLATE);
            output.accept(ORANGE_CHESTPLATE);
            output.accept(FLIGHT_HELMET);
            output.accept(STRENGTH_LEGGINGS);
            output.accept(HERO_BOOTS);
            output.accept(MASTER_WEAPON);
            output.accept(SOLAR_VISOR);
            output.accept(DEEP_SEA_MASK);
            output.accept(FLAMEGUARD_CHESTPLATE);
            output.accept(SHADOW_CLOAK);
            output.accept(KINETIC_BRACERS);
            output.accept(GUARDIAN_GREAVES);
            output.accept(SKYWALKER_BOOTS);
            output.accept(AQUA_FINS);
            output.accept(THUNDER_HAMMER);
            output.accept(LIFE_STAFF);
            output.accept(FROSTFALL_CAPE);
            output.accept(GRAVITY_PICKAXE);
            output.accept(BUILDER_GAUNTLET);
            output.accept(TIMEKEEPER_WATCH);
            output.accept(PHASE_COMPASS);
        });

        ServerTickEvents.END_SERVER_TICK.register(server -> server.getPlayerList().getPlayers().forEach(player -> {
            boolean canFly = player.getItemBySlot(net.minecraft.world.entity.EquipmentSlot.HEAD).is(FLIGHT_HELMET);
            boolean masterWeaponHeld = player.getMainHandItem().is(MASTER_WEAPON) || player.getOffhandItem().is(MASTER_WEAPON);
            boolean protectedMode = player.isCreative() || player.isSpectator();

            if (!protectedMode) {
                boolean abilitiesChanged = player.getAbilities().mayfly != canFly
                    || player.getAbilities().invulnerable != masterWeaponHeld;
                player.getAbilities().mayfly = canFly;
                player.getAbilities().invulnerable = masterWeaponHeld;
                if (!canFly) {
                    player.getAbilities().flying = false;
                }
                if (abilitiesChanged) {
                    player.onUpdateAbilities();
                }
            }
        }));
    }

    private static ResourceKey<Item> itemKey(String id) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, id));
    }

    private static VelocityChestplateItem createChestplate(ResourceKey<Item> key, TrailColor color) {
        return new VelocityChestplateItem(
            new Item.Properties()
                .setId(key)
                .humanoidArmor(ArmorMaterials.DIAMOND, ArmorType.CHESTPLATE),
            color
        );
    }

    private static PowerItem armorPower(ResourceKey<Item> key, PowerMode mode, ArmorType armorType) {
        return new PowerItem(
            new Item.Properties().setId(key).humanoidArmor(ArmorMaterials.NETHERITE, armorType),
            mode,
            armorType == ArmorType.HELMET ? EquipmentSlot.HEAD
                : armorType == ArmorType.LEGGINGS ? EquipmentSlot.LEGS
                : armorType == ArmorType.BOOTS ? EquipmentSlot.FEET : EquipmentSlot.CHEST
        );
    }

    private static PowerItem heldPower(ResourceKey<Item> key, PowerMode mode) {
        return new PowerItem(new Item.Properties().setId(key).stacksTo(1), mode, null);
    }

    private static PowerItem heldWeapon(ResourceKey<Item> key, PowerMode mode, float damage, float speed) {
        return new PowerItem(new Item.Properties().setId(key).sword(ToolMaterial.NETHERITE, damage, speed), mode, null);
    }

    private static PowerItem heldTool(ResourceKey<Item> key, PowerMode mode) {
        return new PowerItem(new Item.Properties().setId(key).pickaxe(ToolMaterial.NETHERITE, 8.0F, -3.0F), mode, null);
    }

    private static void register(ResourceKey<Item> key, Item item) {
        Registry.register(BuiltInRegistries.ITEM, key, item);
    }
}
