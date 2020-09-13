package gallery_service;

public final class Painting {
    private final String name;
    private final String author;
    private final int year;

    public Painting(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + " by " + author + ", " + year + ".";
    }
}
