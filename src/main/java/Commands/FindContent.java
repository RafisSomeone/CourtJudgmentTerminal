package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;

import java.io.FileNotFoundException;

public class FindContent {

        public String searchForContent(String Entry, DataBase base) throws FileNotFoundException {


            for (JudgeFile chosenOne : base.getBase()) {
                String wanted = chosenOne.searchForContent(Entry);
                if (wanted != null) return wanted;

            }
            throw new FileNotFoundException("Metryka " + Entry + " nie istnieje");
        }



}
