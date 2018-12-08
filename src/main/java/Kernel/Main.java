package Kernel;

import Commands.FindRubrum;
import Commands.JudgeCaseCounter;
import Tools.DataBase;

import java.io.IOException;

public class Main {


    public static void main(String[] args)  {

try {
    DataBase mole = new DataBase();
    mole.load("C:\\Users\\rafal\\IdeaProjects\\CourtJudgmentTerminal\\src\\main\\resources");


   System.out.println(new FindRubrum().searchFor("VIII Ka 797/13", mole));
    //System.out.println(new Converter().clean(new FindContent().searchForContent("VIII Ka 797/13", mole)));
    //System.out.println(new FindMore().searchForMore("VIII Ka 797/13,V Pa 51/13,IV CZ 132/13", mole));
   System.out.println(new JudgeCaseCounter().howMany("Anna Miniecka",mole));
    String out = "MAMA";

    //  TerminalBuilder terminal = new TerminalBuilder();

}catch (IOException ex)
{
    System.out.println(ex);

}
    }
}

