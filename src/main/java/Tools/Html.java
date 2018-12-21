package Tools;

import Files.ItemInside.*;

import java.util.List;

public class Html {
    private CourtType courtType;
    private List<Case> courtCases;
    private List<Judge> judges;
    private String textContent;
    private List<Referenced> referencedRegulations;
    private String judgmentDate;

    public Html(CourtType courtType, List<Case> courtCases, List<Judge> judges, String textContent, List<Referenced> referencedRegulations, String judgmentDate) {
        this.courtType = courtType;
        this.courtCases = courtCases;
        this.judges = judges;
        this.textContent = textContent;
        this.referencedRegulations = referencedRegulations;
        this.judgmentDate = judgmentDate;
    }

    public Item htmlToItems(){

        return new Item(this.courtType,this.courtCases,this.judges,this.textContent,this.referencedRegulations,this.judgmentDate);


    }
}
