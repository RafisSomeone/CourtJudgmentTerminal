package Commands;

import Files.ItemInside.CourtType;
import Files.ItemInside.JudgeFile;
import Tools.DataBase;
import tree.Court;
import tree.Month;
import tree.Months;

import java.util.LinkedList;
import java.util.List;

public class StatisticCourt {

    public String statistic (DataBase base)
    {
        List<Court> courts = new LinkedList<>();
        courts.add(new Court(CourtType.ADMINISTRATIVE,0));
        courts.add(new Court(CourtType.COMMON,0));
        courts.add(new Court(CourtType.CONSTITUTIONAL_TRIBUNAL,0));
        courts.add(new Court(CourtType.NATIONAL_APPEAL_CHAMBER,0));
        courts.add(new Court(CourtType.SUPREME,0));
        courts.add(new Court(CourtType.ALL,0));

        for(JudgeFile chosenOne : base.getBase())
        {
            chosenOne.statisticCourt(courts);

        }

        String outCome ="Statistic of courts: \nType of Court               Quantity       Percentage  \n";
        for(Court court : courts)
        {
            outCome+=court.getType();
            for(int i=28-court.getType().toString().length();i>0;i--)outCome+=" ";
            outCome+=court.getCounter();
            if(court.getCounter()==0)for(int i=15;i>0;i--)outCome+=" ";
            else {for (int i = 15 - (int) (Math.log10(court.getCounter()) ); i > 0; i--) outCome += " "; }
            outCome+=Math.round((double) (court.getCounter()/ (double)courts.get(5).getCounter())*100)+"%\n";

        }
        return outCome;

    }
}
