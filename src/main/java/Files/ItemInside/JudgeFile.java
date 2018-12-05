package Files.ItemInside;

import Outcome.Rubrum;

import java.util.List;

public class JudgeFile {

    private List<Item> items;


    public String searchFor(String Entry) {
        for (Item chosenOne : items) {

            String alert = chosenOne.searchFor(Entry);
            if (!alert.equals("Nie ma")) return alert + chosenOne.judgesToString();

        }
        return "Nie ma";
    }
    public String searchForJudges(String Entry) {
        for (Item chosenOne : items) {

            String alert = chosenOne.searchFor(Entry);
            if (!alert.equals("Nie ma")){
                Rubrum tmp = new Rubrum().getFromList(Entry); tmp.sendJudges(chosenOne.getJudges()); return alert + chosenOne.judgesToString();}

        }
        return "Nie ma";
    }


}

