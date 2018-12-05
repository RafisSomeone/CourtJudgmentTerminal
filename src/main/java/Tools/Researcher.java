package Tools;

import Files.ItemInside.JudgeFile;

public class Researcher extends DataBase {
    public Researcher() {

    }


    public String searchFor(String Entry) {
        for (JudgeFile chosenOne : loadedFiles) {

            String allert = chosenOne.searchFor(Entry);
            if (!allert.equals("Nie ma")) return allert;

        }
        return "Nie ma";

    }

}
