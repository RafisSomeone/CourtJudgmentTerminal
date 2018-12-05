package Commands;

import Files.ItemInside.JudgeFile ;
import Tools.DataBase;

public class FindRubrum extends DataBase {

    public String searchFor(String Entry) {
        for (JudgeFile chosenOne : loadedFiles) {

            String alert = chosenOne.searchFor(Entry);
            if (!alert.equals("Nie ma")) return alert;

        }
        return "Nie ma";

    }



}
