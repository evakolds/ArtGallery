package ticket_service;

import java.util.UUID;

public final class Ticket {
    private final String id;
    private final int price;

    Ticket(UUID id, int price) {
        this.id = id.toString();
        this.price = price;
    }

    public String getDescription() {
        return "Ticket #" + id + " ($" + price + ")";
    }
}
