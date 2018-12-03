package Outcome;

import Files.ItemInside.Judge;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Rubrum {
    private  String signature;
    private  String date;
    private  String courtType;
    private  List<Judge> judges;
    private  String text;

    public  Map<String, Rubrum> discoveredRubrums = new LinkedHashMap();

    public Rubrum(){}
    public Rubrum(int journalNo, int journalYear, int journalEntry, String text) {

        this.signature =journalNo + "/" + journalYear + "/" +journalEntry;
        this.text = text;


    }

    public String toString() {
        String out = "Signature: " + signature + "\n" + "Date: " + date + "\n" + "Court Type: " + courtType + "\n" + "Judges: ";

        return out;

    }

    public void save()
    {
        discoveredRubrums.put(this.signature,this);

    }


    public Rubrum getFromList(String signature)
    {
        return discoveredRubrums.get(signature);
    }

    public void sendJudges(List<Judge> judges)
    {
     this.judges=judges;


    }

}
