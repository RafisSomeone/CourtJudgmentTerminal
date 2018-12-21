package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;
import tree.JudgeNumber;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StatisticJudges {

    public String statistic(DataBase base)
    {
        List<JudgeNumber> judgeNumbers=new LinkedList<>();

        for(JudgeFile chosenOne : base.getBase())
        {
            chosenOne.statisticJudges(judgeNumbers);
        }
        int total=0;
        for(JudgeNumber number:judgeNumbers)total+=number.getCounter();
        Set<JudgeNumber> judgeNumbersSorted = new TreeSet<>();
        for(JudgeNumber judgeNumber: judgeNumbers)
        {
            judgeNumbersSorted.add(judgeNumber);
        }
        String outCome="\nStatistic on the number of judges:\nNumber of judges     Quantity      Percentage\n";
        for(JudgeNumber judgeNumber:judgeNumbersSorted)
        {outCome+=judgeNumber.getJudgeQuantity();
        if(judgeNumber.getJudgeQuantity()==0)for(int i=20;i>0;i--)outCome+=" ";
        for(int i=20- (int) (Math.log10(judgeNumber.getJudgeQuantity()));i>0;i--)outCome+=" ";
        outCome+=judgeNumber.getCounter();
        for(int i=13 - (int)(Math.log10(judgeNumber.getCounter()));i>0;i--)outCome+=" ";
        outCome+= Math.round(((double) judgeNumber.getCounter()/(double)total)*100)+"%\n";




        }
        outCome+="TOTAL                "+total+"          100%";
        return outCome;

    }
}
