package Commands;

import Files.ItemInside.JudgeFile ;
import Tools.Loader;

public class FindRubrum extends Loader {

    public String searchFor(String Entry) {
        for (JudgeFile chosenOne : loadedFiles) {

            String allert = chosenOne.searchFor(Entry);
            if (!allert.equals("Nie ma")) return allert;

        }
        return "Nie ma";

    }



}
