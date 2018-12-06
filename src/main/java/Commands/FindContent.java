package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;

import java.io.FileNotFoundException;
import java.util.List;

public class FindContent extends DataBase {

        public String searchForContent(String Entry, DataBase base) throws FileNotFoundException {
            List<JudgeFile> loadedFiles = base.send();

            for (JudgeFile chosenOne : loadedFiles) {
                String wanted = chosenOne.searchForContent(Entry);
                if (wanted != null) return wanted;

            }
            throw new FileNotFoundException("Metryka " + Entry + " nie istnieje");
        }



}
