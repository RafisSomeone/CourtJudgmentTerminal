package Commands;

import Files.ItemInside.JudgeFile;
import Tools.DataBase;

public class JudgeCaseCounter {

    public String howMany(String name, DataBase base)
    {
        int counter=0;

        for(JudgeFile chosenOne : base.getBase())
        {
            counter=counter+chosenOne.howMany(name);
        }
        return name +" has taken part in " + counter + " judgments";





    }




}
