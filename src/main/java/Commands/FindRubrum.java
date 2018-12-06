package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;

import java.io.FileNotFoundException;
import java.util.List;

public class FindRubrum {

    public String searchFor(String Entry, DataBase base) throws FileNotFoundException {


        for (JudgeFile chosenOne : base.send()) {
            String wanted = chosenOne.searchFor(Entry);
            if (wanted != null) return wanted;

        }
        throw new FileNotFoundException("Metryka " + Entry + " nie istnieje");
    }


}
