package gallery_service;

import java.util.LinkedList;

public final class CleaningService {
    final private LinkedList<Janitor> janitors = new LinkedList<>();

    public void addJanitor(Janitor janitor) { janitors.add(janitor); }

    public Janitor getJanitorByName(String name) {
        for (Janitor janitor: janitors)
            if (janitor.getName().equals(name)) return janitor;

        return null;
    }

    public void mop(Janitor moppingJanitor){
        for (Janitor janitor: janitors){
            if (janitor == moppingJanitor) {
                System.out.println("Janitor " + janitor.getName() + " is mopping right now. Caution: wet floor!");
            }
        }
    }

    public void mopDance(Janitor moppingJanitor){
        for (Janitor janitor: janitors){
            if (janitor == moppingJanitor) {
                System.out.println(janitor.getName() + " is dancing with a mop! Someone loves their job.");
            }
        }
    }
}
