package Kernel;


import Commands.*;
import Tools.DataBase;
import Tools.HtmlParser;


import java.io.IOException;



public class Main {


    public static void main(String[] args) throws IOException {
        DataBase mole = new DataBase();
    new HtmlParser().html("/home/rafal/Dokumenty/intellij/IdeaProjects-20181219T161811Z-001/IdeaProjects/CourtJudgmentTerminal/src/main/resources/html",mole);

    mole.load("/home/rafal/Dokumenty/intellij/IdeaProjects-20181219T161811Z-001/IdeaProjects/CourtJudgmentTerminal/src/main/resources/json");
        System.out.println(new JudgeCaseCounter().howMany("Andrzej Cisek",mole));
    System.out.println(new TopJudges().top10(mole));
        System.out.println(new StatisticSentence().statistic(mole));
   //  System.out.println(new TopRegulations().topRegulation(mole));

       // new TerminalEmulator().terminal();


        /*
      String prompt = "prompt> ";
      TerminalEmulator terminal = TerminalBuilder.builder()
              .system(true)
              .build();

      LineReader lineReader= LineReaderBuilder.builder()
              .terminal(terminal)
              .build();

String line ;


        while (true) {
            line = lineReader.readLine(prompt);
            if(line=="asd") System.out.println("FSAF");

        }
       try {

            //DataBase mole = new DataBase();
          //  mole.load("C:\\Users\\rafal\\IdeaProjects\\CourtJudgmentTerminal\\src\\main\\resources");
            // System.out.println(new StatisticJudges().statistic(mole));


            String prompt = "prompt> ";
            String rightPrompt = null;
           TerminalEmulator terminal = TerminalBuilder.builder()
                    .system(true)
                    .build();

            LineReader reader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();

                String line = null;
                try {
                    line = reader.readLine(prompt);
                    if(line=="asd") System.out.println("FSAF");

                } catch (UserInterruptException e) {
                    System.out.println("fdgsfdgsd");
                } catch (EndOfFileException e) {

                }

            }
                //
                //          System.out.println(new StatisticSentence().statistic(mole));
                //    System.out.println(new StatisticCourt().statistic(mole));
                //  System.out.println(new TopJudges().top10(mole));
                // System.out.println("");

                //System.out.println(new FindRubrum().searchFor("VIII Ka 797/13", mole));
                //System.out.println(new Converter().clean(new FindContent().searchForContent("VIII Ka 797/13", mole)));
                //System.out.println(new FindMore().searchForMore("VIII Ka 797/13,V Pa 51/13,IV CZ 132/13", mole));
                //System.out.println(new JudgeCaseCounter().howMany("Wojciech Katner",mole));


                //  TerminalBuilder terminal = new TerminalBuilder();

            } catch(IOException ex){
                System.out.println(ex);

            }
*/

    }
}

