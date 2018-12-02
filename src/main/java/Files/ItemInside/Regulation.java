package Files.ItemInside;

import Outcome.Rubrum;
import Tools.EntryConverter;

public class Regulation {
    private String journalTitle;
    private int journalNo;
    private int journalYear;
    private int journalEntry;
    private String text;


    protected String searchFor(String Entry) {

        int[] Entries = new EntryConverter().convert(Entry);


        if (journalNo == Entries[0] && journalYear == Entries[1] && journalEntry == Entries[2]) {
            Rubrum sentence = new Rubrum(journalNo, journalYear, journalEntry, text);
            sentence.save();
            return sentence.toString();

        } else return "Nie ma";


    }


}
