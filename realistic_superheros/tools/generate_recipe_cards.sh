#!/usr/bin/env bash
set -euo pipefail

root="$(cd "$(dirname "$0")/.." && pwd)"
ingredients="$root/docs/recipe-assets"
custom="$root/src/main/resources/assets/realistic_superheros/textures/item"
cards="$root/docs/recipe-assets/recipes"
mkdir -p "$cards"

render() {
    local name="$1" label="$2" output="$3" row1="$4" row2="$5" row3="$6"
    local card="$cards/$name.png"
    convert -size 440x220 xc:"#171b24" \
        -fill "#252c3a" -stroke "#667085" -strokewidth 2 \
        -draw "rectangle 18,18 72,72 rectangle 76,18 130,72 rectangle 134,18 188,72 rectangle 18,76 72,130 rectangle 76,76 130,130 rectangle 134,76 188,130 rectangle 18,134 72,188 rectangle 76,134 130,188 rectangle 134,134 188,188" \
        -fill white -stroke none -draw "line 245,88 335,88" -draw "polyline 325,78 335,88 325,98" \
        -pointsize 17 -annotate +215+205 "$label" "$card"

    local row=0 cells token icon col
    for cells in "$row1" "$row2" "$row3"; do
        IFS=, read -r -a slots <<< "$cells"
        for col in 0 1 2; do
            token="${slots[$col]}"
            [[ "$token" == "_" ]] && continue
            if [[ -f "$ingredients/$token.png" ]]; then
                icon="$ingredients/$token.png"
            else
                icon="$custom/$token.png"
            fi
            resized=$(mktemp --suffix=.png)
            convert "$icon" -resize 46x46 "$resized"
            composite -geometry "+$((22 + col * 58))+$((22 + row * 58))" "$resized" "$card" "$card"
            rm -f "$resized"
        done
        row=$((row + 1))
    done
    resized=$(mktemp --suffix=.png)
    convert "$custom/$output.png" -resize 54x54 "$resized"
    composite -geometry +365+58 "$resized" "$card" "$card"
    rm -f "$resized"
}

render velocity_chestplate_i "Velocity I" velocity_chestplate_i "phantom_membrane,_,phantom_membrane" "phantom_membrane,diamond,blue_dye" "phantom_membrane,phantom_membrane,phantom_membrane"
render velocity_chestplate_ii "Velocity II" velocity_chestplate_ii "phantom_membrane,_,phantom_membrane" "phantom_membrane,diamond,yellow_dye" "phantom_membrane,phantom_membrane,phantom_membrane"
render velocity_chestplate_iii "Velocity III" velocity_chestplate_iii "phantom_membrane,_,phantom_membrane" "phantom_membrane,diamond,green_dye" "phantom_membrane,phantom_membrane,phantom_membrane"
render velocity_chestplate_iv "Velocity IV" velocity_chestplate_iv "phantom_membrane,_,phantom_membrane" "phantom_membrane,diamond,orange_dye" "phantom_membrane,phantom_membrane,phantom_membrane"
render velocity_chestplate_v "Velocity V" velocity_chestplate_v "phantom_membrane,_,phantom_membrane" "phantom_membrane,diamond,red_dye" "phantom_membrane,phantom_membrane,phantom_membrane"
render aerial_flight_helmet "Flight Helmet" aerial_flight_helmet "diamond,_,diamond" "phantom_membrane,feather,phantom_membrane" "_,diamond,_"
render titan_strength_leggings "Strength Leggings" titan_strength_leggings "diamond,_,diamond" "diamond,phantom_membrane,diamond" "diamond,_,diamond"
render meteor_jump_boots "Jump Boots" meteor_jump_boots "diamond,_,diamond" "diamond,rabbit_foot,diamond" "_,_,_"
render absolute_power_sword "Power Sword" absolute_power_sword "_,echo_shard,_" "_,netherite_ingot,_" "_,nether_star,_"
render solar_vision_visor "Vision Visor" solar_vision_visor "gold_ingot,gold_ingot,gold_ingot" "gold_ingot,ender_eye,gold_ingot" "_,diamond,_"
render deep_sea_mask "Sea Mask" deep_sea_mask "prismarine_shard,prismarine_shard,prismarine_shard" "prismarine_shard,nautilus_shell,prismarine_shard" "_,diamond,_"
render flameguard_chestplate "Flameguard" flameguard_chestplate "magma_cream,_,magma_cream" "magma_cream,netherite_ingot,magma_cream" "magma_cream,magma_cream,magma_cream"
render shadow_cloak "Shadow Cloak" shadow_cloak "phantom_membrane,phantom_membrane,phantom_membrane" "phantom_membrane,black_dye,diamond" "phantom_membrane,phantom_membrane,phantom_membrane"
render kinetic_bracers "Kinetic Bracers" kinetic_bracers "iron_ingot,redstone,iron_ingot" "iron_ingot,diamond,iron_ingot" "iron_ingot,redstone,iron_ingot"
render guardian_greaves "Guardian Greaves" guardian_greaves "iron_ingot,diamond,iron_ingot" "iron_ingot,amethyst_shard,iron_ingot" "iron_ingot,diamond,iron_ingot"
render skywalker_boots "Skywalker Boots" skywalker_boots "feather,_,feather" "diamond,phantom_membrane,diamond" "_,_,_"
render aqua_fins "Aquatic Fins" aqua_fins "prismarine_shard,_,prismarine_shard" "prismarine_shard,leather,prismarine_shard" "_,_,_"
render thunder_hammer "Thunder Hammer" thunder_hammer "netherite_ingot,blaze_rod,netherite_ingot" "_,stick,_" "_,stick,_"
render life_staff "Life Staff" life_staff "_,ghast_tear,_" "_,emerald,_" "_,stick,_"
render frostfall_cape "Frostfall Cape" frostfall_cape "packed_ice,packed_ice,packed_ice" "packed_ice,blue_ice,diamond" "packed_ice,packed_ice,packed_ice"
render gravity_pickaxe "Gravity Pickaxe" gravity_pickaxe "echo_shard,echo_shard,echo_shard" "_,stick,_" "_,stick,_"
render builder_gauntlet "Builder Gauntlet" builder_gauntlet "iron_ingot,redstone,iron_ingot" "iron_ingot,diamond,iron_ingot" "iron_ingot,redstone,iron_ingot"
render timekeeper_watch "Timekeeper Watch" timekeeper_watch "_,gold_ingot,_" "gold_ingot,clock,gold_ingot" "_,gold_ingot,_"
render phase_compass "Phase Compass" phase_compass "_,amethyst_shard,_" "amethyst_shard,ender_pearl,amethyst_shard" "_,amethyst_shard,_"

montage "$cards"/*.png -tile 3x -geometry +20+20 -background "#0d1117" "$root/docs/recipe-assets/recipe-cards-atlas.png"
