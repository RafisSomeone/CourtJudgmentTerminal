package Files.ItemInside;

import java.util.List;

public class Files {

    private List<Item> items;


    public String searchFor(String Entry) {
        for (Item chosenOne : items) {

            String alert = chosenOne.searchFor(Entry);
            if (!alert.equals("Nie ma")) return alert;

        }
        return "Nie ma";
    }


}

