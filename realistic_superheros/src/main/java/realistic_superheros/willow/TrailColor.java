package realistic_superheros.willow;

public enum TrailColor {
    BLUE("blue", 0x3B82F6, 0),
    YELLOW("yellow", 0xFACC15, 1),
    GREEN("green", 0x22C55E, 2),
    ORANGE("orange", 0xF97316, 3),
    RED("red", 0xEF4444, 4);

    private final String id;
    private final int particleColor;
    private final int speedAmplifier;

    TrailColor(String id, int particleColor, int speedAmplifier) {
        this.id = id;
        this.particleColor = particleColor;
        this.speedAmplifier = speedAmplifier;
    }

    public String id() {
        return id;
    }

    public int particleColor() {
        return particleColor;
    }

    public int speedAmplifier() {
        return speedAmplifier;
    }
}