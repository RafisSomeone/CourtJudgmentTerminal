package Outcome;

import Files.ItemInside.String;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Rubrum {
    private java.lang.String signature;
    private java.lang.String date;
    private java.lang.String courtType;
    private  List<String> strings;
    private java.lang.String text;

    public  Map<java.lang.String, Rubrum> discoveredRubrums = new LinkedHashMap();

    public Rubrum(){}
    public Rubrum(int journalNo, int journalYear, int journalEntry, java.lang.String text) {

        this.signature =journalNo + "/" + journalYear + "/" +journalEntry;
        this.text = text;


    }

    public java.lang.String toString() {
        java.lang.String out = "Signature: " + signature + "\n" + "Date: " + date + "\n" + "Court Type: " + courtType + "\n" + "Judges: ";

        return out;

    }

    public void save()
    {
        discoveredRubrums.put(this.signature,this);

    }


    public Rubrum getFromList(java.lang.String signature)
    {
        return discoveredRubrums.get(signature);
    }

    public void sendJudges(List<String> strings)
    {
     this.strings = strings;


    }

}
