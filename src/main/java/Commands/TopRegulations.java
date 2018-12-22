package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;
import tree.Regulate;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TopRegulations {


    public String topRegulation(DataBase base) {
        List<Regulate> regulations = new LinkedList<>();

        for (JudgeFile chosenOne : base.getBase()) {
            chosenOne.topRegulation(regulations);
        }
        Set<Regulate> regulationsSorted = new TreeSet<>();
        for (Regulate regulation : regulations) {
            regulationsSorted.add(regulation);
        }
        String outCome = "\nTop of the Regulations:\nNo    Quantity     Title\n";

        int top = 10;
        int j = 1;
        for (Regulate regulation : regulationsSorted) {
            if (top == 0) return outCome;
            top--;
            outCome += j + ".  ";
            for(int i=3-(int) (Math.log10(j) + 1);i>0;i--)outCome+=" ";

            for (int i = (20 - regulation.getTitle().length()); i > 0; i--) outCome += " ";
            outCome += regulation.getCounter();
            for(int i =13- (int) (Math.log10(regulation.getCounter()) + 1);i>0;i--) outCome+=" ";
               outCome+=regulation.getTitle() + "\n";
            j++;
        }

        return outCome;
    }

}
