package realistic_superheros.willow;

public enum PowerMode {
    NIGHT_VISION("Permanent Night Vision", "equipment"),
    DEEP_SEA("Water Breathing and Dolphin's Grace", "equipment"),
    FIREPROOF("Fire Resistance", "equipment"),
    SHADOW("Invisibility", "equipment"),
    HASTE("Haste III while held", "held"),
    RESISTANCE("Resistance II", "equipment"),
    SKYRUNNER("Speed II and Jump Boost II", "equipment"),
    FINSPRINT("Water Breathing and Dolphin's Grace", "equipment"),
    THUNDER("Strength IV and Resistance II while held", "held"),
    HEALING("Regeneration III and Absorption III while held", "held"),
    FROSTFALL("Slow Falling and Resistance I", "equipment"),
    MINING("Haste IV while held", "held"),
    BUILDER("Haste II and Speed I while held", "held"),
    TIMEKEEPER("Night Vision and Slow Falling while held", "held"),
    PHASE("Invisibility and Speed I while held", "held");

    private final String description;
    private final String activation;

    PowerMode(String description, String activation) {
        this.description = description;
        this.activation = activation;
    }

    public String description() {
        return description + " (" + activation + ")";
    }
}