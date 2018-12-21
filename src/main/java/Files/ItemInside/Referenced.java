package Files.ItemInside;

import tree.Regulate;

import java.util.List;

public class Referenced {
    private String journalTitle;
    private int journalNo;
    private int journalYear;
    private int journalEntry;
    private String text;

    public Referenced(String journalTitle){
        this.journalTitle=journalTitle;
    }


public void topRegulation(List<Regulate> regulations)
{


    for(Regulate regulation:regulations)
    {
        if(regulation.getTitle().equals(journalTitle)){regulation.increaseCounter();return;}

    }
    regulations.add(new Regulate(1,journalTitle));
}


}
