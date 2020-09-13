package exhibition_service;

public final class Exhibition {
    private final String name;
    private int open;

    public Exhibition(String name, int open) {
        if (open == 1 || open == 0)
            this.open = open;
        else
            this.open = 0;

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void open() {
        if (open == 0)
            open = 1;
    }

    public void close() {
        if (open == 1)
            open = 0;
    }
}
