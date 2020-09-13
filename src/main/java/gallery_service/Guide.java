package gallery_service;

public final class Guide {
    final public String name;
    private int eloquenceLevel;

    public Guide(String name, int eloquenceLevel) {
        this.name = name;

        if (eloquenceLevel <= 10 && eloquenceLevel > 0)
            this.eloquenceLevel = eloquenceLevel;
        else
            this.eloquenceLevel = 1;
    }

    public String getName() {
        return name;
    }

    public void talk() {
        if (eloquenceLevel < 10)
            eloquenceLevel += 1;

        System.out.println("Now the guide's eloquence level is " + eloquenceLevel + ".");
    }
}
