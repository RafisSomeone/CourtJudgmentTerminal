package Tools;

import Files.ItemInside.*;

import java.util.LinkedList;
import java.util.List;

public class HtmlBuilder {

    private CourtType courtType;
    private List<Case> courtCases;
    private List<Judge> judges;
    private String textContent;
    private List<Referenced> referencedRegulations;
    private String judgmentDate;

    public HtmlBuilder() {

    }

    public HtmlBuilder setCourtType(CourtType courtType) {
        this.courtType = courtType;
        return this;
    }

    public HtmlBuilder setCourtCases(String courtCase) {
        List<Case> courtCases = new LinkedList<>();
        Case newCase = new Case(courtCase);
        courtCases.add(newCase);
        this.courtCases = courtCases;
        return this;
    }

    public HtmlBuilder setJudges(List<Judge> judges) {
        this.judges = judges;
        return this;
    }

    public HtmlBuilder setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public HtmlBuilder setReferencedRegulations(List<Referenced> referencedRegulations) {
        this.referencedRegulations = referencedRegulations;
        return this;
    }

    public HtmlBuilder setJudgmentDate(String judgmentDate) {
        this.judgmentDate = judgmentDate;
        return this;
    }

    public Html build() {
        return new Html(courtType, courtCases, judges, textContent, referencedRegulations, judgmentDate);
    }


}
