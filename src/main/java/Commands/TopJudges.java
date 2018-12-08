package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;
import tree.JudgeValue;

import java.util.Set;
import java.util.TreeSet;

public class TopJudges {


    public String top10(DataBase base) {
        int top = 10;
        Set<JudgeValue> judgeValueSet = new TreeSet<>();


        for (JudgeFile chosenOne : base.getBase()) {
            chosenOne.top(judgeValueSet);
        }
        Set<JudgeValue> judgeValuesSorted = new TreeSet<>();

        for (JudgeValue value : judgeValueSet) {
            judgeValuesSorted.add(value);
        }


        String outCome = "Top "+ top + " of the most active judges: \n";
        int i = 1;
        for (JudgeValue value : judgeValuesSorted) {
            outCome=outCome + i+ ". "+ value.getName()+ " " + value.getCoutner()+" jugments\n";
            if (i == top) break;
            i++;
        }

return outCome;
    }
}
