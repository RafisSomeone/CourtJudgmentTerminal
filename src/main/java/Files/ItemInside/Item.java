package Files.ItemInside;

import tree.*;

import java.util.List;
import java.util.Set;

public class Item {
    private int id;
    private CourtType courtType;
    private List<Case> courtCases;
    private JudgmentType judgmentType;
    private List<Judge> judges;
    private Source source;
    private List<String> courtReporters;
    private String decision;
    private String summary;
    private String textContent;
    private List<String> legalBases;
    private List<ReferencedRegulation> referencedRegulations;
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
            String name = judge.getName();
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
            if(name.equals(chosenOne.getName())) {  return 1;
               }
        }
        return 0;


    }
    public void top (Set<JudgeValue> judgeValues)
    {
        for(Judge chosenOne : judges)
        {
          boolean flag = false;
            for(JudgeValue value:judgeValues)
            {
                if(value.getName().equals(chosenOne.getName()))
                {
                    flag=true;
                    value.increaseCounter();
                    break;
                }
            }
            if(flag==false)judgeValues.add(new JudgeValue(chosenOne.getName(),1));

        }
    }

    public void statisticSentence(List<Month> year )
    {
        if(judgmentType.equals(JudgmentType.SENTENCE))// tylko dla wyroków w razie potrzeby wyniku dla wyroków usunąć ifa
        {
            int month =(judgmentDate.charAt(5)-48)*10+judgmentDate.charAt(6)-48-1;
            year.get(month).increaseCounter();
            year.get(12).increaseCounter();

        }


    }
    public void statisticCourt(List<Court> courts )
    {
       if(judgmentType.equals(JudgmentType.SENTENCE))// tylko dla wyroków w razie potrzeby wyniku dla wyroków usunąć ifa
        {

            for(Court court:courts)
            {
                if(court.getType().equals(courtType))court.increaseCounter();
            }
            courts.get(5).increaseCounter();

        }


    }
    public void topRegulation(List<Regulation> regulations)
    {
        for(ReferencedRegulation referencedRegulation : referencedRegulations)
        {
            referencedRegulation.topRegulation(regulations);

        }

    }






















    public void statisticJudges(List<JudgeNumber> judgeNumbers) {

        for(JudgeNumber number : judgeNumbers)
        {
            if(number.getJudgeQuantity()==judges.size()){number.increaseCounter();return;}

        }
        judgeNumbers.add(new JudgeNumber(judges.size(),1));
    }
}