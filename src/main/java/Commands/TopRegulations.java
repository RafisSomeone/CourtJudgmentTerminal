package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;
import tree.Regulation;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TopRegulations {


    public String topRegulation(DataBase base) {
        List<Regulation> regulations = new LinkedList<>();

        for (JudgeFile chosenOne : base.getBase()) {
            chosenOne.topRegulation(regulations);
        }
        Set<Regulation> regulationsSorted = new TreeSet<>();
        for (Regulation regulation : regulations) {
            regulationsSorted.add(regulation);
        }
        String outCome = "Top of the Regulations:\nNo    journalNo/Year      Quantity\n";

        int top = 10;
        int j = 1;
        for (Regulation regulation : regulationsSorted) {
            if (top == 0) return outCome;
            top--;
            outCome += j + ".  ";
            for(int i=3-(int) (Math.log10(j) + 1);i>0;i--)outCome+=" ";
            outCome += regulation.getSignature();
            for (int i = (20 - regulation.getSignature().length()); i > 0; i--) outCome += " ";
            outCome += regulation.getCounter() + "\n"; // by poznać tytuł regulacji +regulation.getTitle()
            j++;
        }

        return outCome;
    }

}