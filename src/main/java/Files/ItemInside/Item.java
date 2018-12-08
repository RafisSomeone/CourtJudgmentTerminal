package Files.ItemInside;

import java.util.List;

public class Item {
    private int id;
    private CourtType courtType;
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
    private List<Opinion> dissentingOpinions;
    private String judgmentDate;


    protected String searchFor(String Entry) {
        String wanted = courtCases.get(0).getCaseNumber();
        if (wanted.equals(Entry)) {
            String rubrum = "Case number: " + wanted;

            rubrum = rubrum + "\n Date:" + judgmentDate + "\n Court type: " + courtType.toString() + "\n Jugdes: " + judges.toString();


            return rubrum;
        } else return null;


    }
    protected String searchForContent(String Entry) {
        String wanted = courtCases.get(0).getCaseNumber();
        if (wanted.equals(Entry)) {

            return textContent;
        } else return null;


    }


    protected String judgesToString() {
        String out = "";
        int i = 0;
        for (Judge judge : this.judges) {
            i++;
            String name = judge.toString();
            out = out + name;
            if (i != this.judges.size()) out = out + ", ";


        }
        return out;


    }

    protected List<Judge> getJudges() {
        return this.judges;
    }

    public int howMany(String name) {

        for (Judge chosenOne : judges) {
            if(name.equals(chosenOne.toString())) return 1;
        }
        return 0;


    }


}