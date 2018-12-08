package Commands;


import Tools.DataBase;

import java.io.FileNotFoundException;
import java.util.List;

public class FindContent {

        public String searchForContent(String Entry, DataBase base) throws FileNotFoundException {


            for (JudgeFile chosenOne : base.send()) {
                String wanted = chosenOne.searchForContent(Entry);
                if (wanted != null) return wanted;

            }
            throw new FileNotFoundException("Metryka " + Entry + " nie istnieje");
        }



}
