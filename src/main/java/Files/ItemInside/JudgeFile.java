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



}

