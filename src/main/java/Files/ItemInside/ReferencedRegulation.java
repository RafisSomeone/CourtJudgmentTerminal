package Files.ItemInside;

import tree.Regulation;

import java.util.List;

public class ReferencedRegulation {
    private String journalTitle;
    private int journalNo;
    private int journalYear;
    private int journalEntry;
    private String text;


public void topRegulation(List<Regulation> regulations)
{
    String signature=journalNo+"/"+journalYear;

    for(Regulation regulation:regulations)
    {
        if(regulation.getSignature().equals(signature)){regulation.increaseCounter();return;}

    }
    regulations.add(new Regulation(signature,1,journalTitle));
}


}
