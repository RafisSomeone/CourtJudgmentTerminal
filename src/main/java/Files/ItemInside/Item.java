package Files.ItemInside;

import java.util.List;

public class Item {
    private int id;
    private CourtType courtType;
    private List<Case> courtCases;
    private java.lang.String judgmentType;
    private List<String> strings;
    private Source source;
    private List<java.lang.String> courtReporters;
    private java.lang.String decision;
    private java.lang.String summary;
    private java.lang.String textContent;
    private List<java.lang.String> legalBases;
    private List<Regulation> referencedRegulations;
    private List<java.lang.String> keywords;
    private List<Case> referencedCourtCases;
    private java.lang.String receiptDate;
    private java.lang.String meansOfAppeal;
    private java.lang.String judgmentResult;
    private Division division;
    private List<java.lang.String> lowerCourtJudgments;
    private List<Opinion> dissentingOpinions;
    private java.lang.String judgmentDate;


    protected java.lang.String searchFor(java.lang.String Entry) {
        java.lang.String wanted = courtCases.get(0).getCaseNumber();
        if (wanted.equals(Entry)) {
            java.lang.String rubrum = "Case number: " + wanted;

           rubrum = rubrum + "\n Date:" + judgmentDate + "\n Court type: " + courtType.toString() + "\n Jugdes: " + strings.toString();


            return rubrum;
        } else return null;


    }
    protected java.lang.String searchForContent(java.lang.String Entry) {
        java.lang.String wanted = courtCases.get(0).getCaseNumber();
        if (wanted.equals(Entry)) {

            return textContent;
        } else return null;


    }


    protected java.lang.String judgesToString() {
        java.lang.String out = "";
        int i = 0;
        for (String string : this.strings) {
            i++;
            java.lang.String name = string.toString();
            out = out + name;
            if (i != this.strings.size()) out = out + ", ";


        }
        return out;


    }

    protected List<String> getStrings() {
        return this.strings;
    }

    public int howMany(java.lang.String name) {

        for (String chosenOne : strings) {
            if(name.equals(chosenOne.toString())) return 1;
        }
        return 0;


    }


}