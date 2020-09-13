package gallery_service;

import java.util.UUID;

public final class Headset {
    private final boolean broken;
    private final String id;

    public Headset(boolean broken, UUID id) {
        this.broken = broken;
        this.id = id.toString();
    }

    public String getId() {
        return id;
    }

    public boolean isBroken() {
        return broken;
    }
}
