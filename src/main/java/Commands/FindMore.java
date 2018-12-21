package Commands;

import Tools.DataBase;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class FindMore {


    public String searchForMore(String Entry, DataBase base) throws FileNotFoundException // Entry looks like "Rubrum,Rubrum,Rubrum"
    {
        List<String> rubrumToFind = new LinkedList<String>();

        String rubrum = "";

        for (int i = 0; i < Entry.length(); i++) {
            char part = Entry.charAt(i);

            if (part == ',') {
                rubrumToFind.add(rubrum);
                rubrum = "";
            } else {rubrum = rubrum + part;}

        }  rubrumToFind.add(rubrum);
        String outCome = "";
       for (String wanted : rubrumToFind) {

            outCome = outCome + new FindRubrum().searchFor(wanted,base) + "\n";

        }

        return outCome;

    }


}
