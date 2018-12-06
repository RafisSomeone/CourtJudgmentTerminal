package Files.ItemInside;

import java.util.List;

public class JudgeFile {

    private List<Item> items;


    public String searchFor(String Entry) {

        for (Item chosenOne : items) {
            String wanted = chosenOne.searchFor(Entry);
            if (wanted != null) return wanted;

        }
        return null;


    }

    public String searchForContent(String Entry) {

        for (Item chosenOne : items) {
            String wanted = chosenOne.searchForContent(Entry);
            if (wanted != null) return wanted;

        }
        return null;


    }

    public int howMany(String name) {
        int counter = 0;
        for (Item chosenOne : items) {
            counter = counter + chosenOne.howMany(name);
        }
        return counter;


    }


}

