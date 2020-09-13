package gallery_service;

public final class Guide {
    final public String name;
    private int eloquenceLevel;

    public Guide(String name, int eloquenceLevel) {
        this.name = name;
        this.eloquenceLevel = (eloquenceLevel > 0 && eloquenceLevel <= 10) ? eloquenceLevel : 1;
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
