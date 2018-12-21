package Commands;

import Files.ItemInside.JudgeFile;
import Tools.Converter;
import Tools.DataBase;

import java.io.FileNotFoundException;

public class FindContent {

        public String searchForContent(String Entry, DataBase base) throws FileNotFoundException {


            for (JudgeFile chosenOne : base.getBase()) {
                String wanted = chosenOne.searchForContent(Entry);
                if (wanted != null) return new Converter().clean(wanted);

            }
            throw new FileNotFoundException("Metryka " + Entry + " nie istnieje");
        }



}
