package Tools;

import Files.ItemInside.Case;
import Files.ItemInside.CourtType;
import Files.ItemInside.Judge;
import Files.ItemInside.Referenced;

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
}
