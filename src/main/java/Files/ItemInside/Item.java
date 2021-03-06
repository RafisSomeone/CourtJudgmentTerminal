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
    private List<Referenced> referencedRegulations;
    private List<String> keywords;
    private List<Case> referencedCourtCases;
    private String receiptDate;
    private String meansOfAppeal;
    private String judgmentResult;
    private Division division;
    private List<String> lowerCourtJudgments;
    private List<Opinion> dissentingOpinions;
    private String judgmentDate;


    public Item(CourtType courtType,List<Case> courtCases,List<Judge> judges,String textContent,List<Referenced> referencedRegulations,String judgmentDate){




     this.courtType=courtType;
       this.courtCases=courtCases;
        this.judges=judges;
       this.textContent=textContent;
         this.referencedRegulations=referencedRegulations;
         this.judgmentDate=judgmentDate;

    }

    protected String searchFor(String Entry) {
        String wanted = courtCases.get(0).getCaseNumber();
        if (wanted.equals(Entry)) {
            String rubrum = "Case number: " + wanted;

            rubrum = rubrum + "\nDate:" + judgmentDate + "\nCourt type: " + courtType.toString() + "\nJugdes: " ;
            int i=0;
            for(Judge judge : judges)
            {
                if(i!=0)rubrum+="        ";
                rubrum+=judge.getName();
                if(judge.getSpecialRoles()!=null)rubrum+=" jako "+ judge.getSpecialRoles();
                rubrum+="\n";
                i++;

            }


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

            int month =(judgmentDate.charAt(5)-48)*10+judgmentDate.charAt(6)-48-1;
            year.get(month).increaseCounter();
            year.get(12).increaseCounter();




    }
    public void statisticCourt(List<Court> courts )
    {


            for(Court court:courts)
            {
                if(court.getType().equals(courtType))court.increaseCounter();
            }
            courts.get(6).increaseCounter();




    }
    public void topRegulation(List<Regulate> regulations)
    {
        for(Referenced referenced : referencedRegulations)
        {
            referenced.topRegulation(regulations);

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