package Files.ItemInside;

import tree.Regulate;

import java.util.List;

public class Referenced {
    private String journalTitle;
    private int journalNo;
    private int journalYear;
    private int journalEntry;
    private String text;


public void topRegulation(List<Regulate> regulations)
{
    String signature=journalNo+"/"+journalYear;

    for(Regulate regulation:regulations)
    {
        if(regulation.getSignature().equals(signature)){regulation.increaseCounter();return;}

    }
    regulations.add(new Regulate(signature,1,journalTitle));
}


}
