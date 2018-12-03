package Files.ItemInside;

import java.util.List;

public class Item {
    private int id;
    private String courtType;
    private List<Case> courtCases;
    private String judgmentType;
    private List<Judge> judges;
    private Source source;
    private List<String> courtReporters;
    private String decision;
    private String summary;
    private String textContent;
    private List<String> legalBases;
    private List<Regulation> referencedRegulations;
    private List<String> keywords;
    private List<Case> referencedCourtCases;
    private String receiptDate;
    private String meansOfAppeal;
    private String judgmentResult;
    private Division division;
    private List<String> lowerCourtJudgments;
    private List<String> dissentingOpinions;
    private String judgmentDate;


    protected String searchFor(String Entry) {
        for (Regulation chosenOne : referencedRegulations) {
            String alert = chosenOne.searchFor(Entry);
            if (!alert.equals("Nie ma"))  { return alert;}

        }
        return "Nie ma";


    }



protected String judgesToString() {
    String out = "";
    int i=0;
    for (Judge judge : this.judges) {
        i++;
        String name =judge.toString();
        out = out + name ;
        if(i!=this.judges.size()) out = out + ", ";


    }
    return out;




}

    protected List<Judge> getJudges()
    {
        return this.judges;
    }
}