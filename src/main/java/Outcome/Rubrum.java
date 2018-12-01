package Outcome;

import Files.ItemInside.Judge;

import java.util.List;

public class Rubrum {
    String signature;
    String date;
    String courtType;
    List<Judge> judges;
    String text;

    public Rubrum(String signature ,int a,int b, int c, String text) {

        this.signature=signature;

        this.text=text;


    }

    public String toString(){
        String out = "Signature: " + signature + "\n"+ "Date: " + date + "\n" + "Court Type: " + courtType + "\n" + "Judges: ";
    for (Judge judge: judges)
    {
        out=out + judge.toString() + " ";

    }


        return out;

    }


}
