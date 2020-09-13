package gallery_service;

public final class TourService {
    public void describePainting(Guide guide,
                                 Painting painting) {

        System.out.println("Guide " + guide.getName() + " is describing a painting nearby. It's " + painting);

        guide.talk();
    }

    public void examinePainting(Visitor visitor,
                                Painting painting) {

        System.out.println(visitor.getName() + " is looking at " + painting.getName() + ". Too many thoughts...");
    }

    public void admirePainting(Visitor visitor,
                               Painting painting) {

        System.out.println(visitor.getName() + " is loving " + painting.getName() + ". " +
                painting.getAuthor() + " did a great job!");
    }

    public void criticizePainting(Visitor visitor,
                                  Painting painting) {

        System.out.println(visitor.getName() + " hates " + painting.getName() + ". " +
                "Did they even know how to draw in " + painting.getYear() + "?");
    }

    public void discussPainting(Visitor visitor1,
                                Visitor visitor2,
                                Painting painting) {

        System.out.println(visitor1.getName() + " and " + visitor2.getName() + " are discussing " +
                painting.getName() + ". So profound, such mastery!");
    }

    public void interrupt(Visitor visitor,
                          Guide guide) {

        System.out.println(visitor.getName() + " interrupts " + guide.getName() + ". How impolitely!");
    }
}
