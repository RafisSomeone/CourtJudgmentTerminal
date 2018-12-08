package Commands;


import Tools.DataBase;

import java.util.TreeSet;

public class TopJudges {





    public String top(DataBase base)
    {
        TreeSet<String> topJudges = new TreeSet<String>();




        topJudges.add("DASDA");

        topJudges.add("CCCCASDASD");

        topJudges.add("ZZX");

       // Comparator comp = ((TreeSet<JudgeValue>) topJudges).comparator();
     for(String wanted : topJudges )
        {
            return wanted;
       }

return null;
    }




}
