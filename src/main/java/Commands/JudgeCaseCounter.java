package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;

public class JudgeCaseCounter {

    public int howMany(String name, DataBase base)
    {
        int counter=0;
        for(JudgeFile chosenOne : base.send())
        {
            counter=counter+chosenOne.howMany(name);
        }
        return counter;





    }




}
