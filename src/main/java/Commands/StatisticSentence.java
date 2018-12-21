package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;
import tree.Month;
import tree.Months;

import java.util.LinkedList;
import java.util.List;

public class StatisticSentence {


    public String statistic (DataBase base)
    {
        List<Month> year = new LinkedList<>();
        year.add(new Month(Months.JANUARY,0));
        year.add(new Month(Months.FEBRUARY,0));
        year.add(new Month(Months.MARCH,0));
        year.add(new Month(Months.APRIL,0));
        year.add(new Month(Months.MAY,0));
        year.add(new Month(Months.JUNE,0));
        year.add(new Month(Months.JULY,0));
        year.add(new Month(Months.AUGUST,0));
        year.add(new Month(Months.SEPTEMBER,0));
        year.add(new Month(Months.OCTOBER,0));
        year.add(new Month(Months.NOVEMBER,0));
        year.add(new Month(Months.DECEMBER,0));
        year.add(new Month(Months.ALL,0));

        for(JudgeFile chosenOne : base.getBase())
        {
            chosenOne.statisticSentence(year);

        }

        String outCome ="\nStatistic of sentences: \nMonth       Quantity       Percentage  \n";
        for(Month month : year)
        {
            outCome+=month.getMonth();
            for(int i=12-month.getMonth().toString().length();i>0;i--)outCome+=" ";
            outCome+=month.getCounter();
            if(month.getCounter()==0)for(int i=14;i>0;i--)outCome+=" ";
            else {
                for (int i = 15 - (int) (Math.log10(month.getCounter()) + 1); i > 0; i--) outCome += " ";
            }
            outCome+=Math.round((double) (month.getCounter()/ (double)year.get(12).getCounter())*100)+"%\n";

        }
        return outCome;

    }


}
