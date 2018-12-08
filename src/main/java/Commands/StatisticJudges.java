package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;
import tree.JudgeNumber;

import java.util.LinkedList;
import java.util.List;

public class StatisticJudges {

    public int statisctic(DataBase base)
    {
        List<JudgeNumber> judgeNumbers=new LinkedList<>();

        for(JudgeFile chosenOne : base.getBase())
        {
            chosenOne.statisticJudges(judgeNumbers);
        }

        return judgeNumbers.get(0).getCounter();

    }
}
