package Tools;


import Commands.*;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TerminalEmulator {


    public void terminal() throws IOException {

        String prompt = "CourtJudgmentTerminal> ";

        Terminal terminal = (Terminal) TerminalBuilder.builder()
                .system(true)
                .build();
        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build();
        DataBase mole = new DataBase();

        /*
        boolean isJsonLoaded = false;
        while (!isJsonLoaded) {
            System.out.println("Enter the path to the directory with JSON files");
            String line = reader.readLine(prompt);
            try {

                mole.load(line); ///home/rafal/Dokumenty/intellij/IdeaProjects-20181219T161811Z-001/IdeaProjects/CourtJudgmentTerminal/src/main/resources/json
                isJsonLoaded = true;

            } catch (NullPointerException ex) {
                System.out.println(line + " is not a path");

            } catch (FileNotFoundException ex) {
                File json = new File(line);

                System.out.println("There is no JSON files in directory " + json.getName());


            }

        }*/

       boolean isHtmlLoaded = false;
        while (!isHtmlLoaded) {
            System.out.println("Enter the path to the directory with HTML files");
            String line = reader.readLine(prompt);
            try {

                new HtmlParser().html(line, mole); ///home/rafal/Dokumenty/intellij/IdeaProjects-20181219T161811Z-001/IdeaProjects/CourtJudgmentTerminal/src/main/resources/html
                isHtmlLoaded = true;

            } catch (NullPointerException ex) {
                System.out.println(line + "is not a path");
            } catch (FileNotFoundException ex) {
                File html = new File(line);
                System.out.println("There is no HTML files in directory " + html.getName());


            }
        }


        while (true) {
            String line = null;
            try {

                line = reader.readLine(prompt);
                line = line.trim();


                switch (line) {
                    case "judges":
                        System.out.println(new TopJudges().top10(mole));
                        break;
                    case "months":
                        System.out.println(new StatisticSentence().statistic(mole));
                        break;
                    case "courts":
                        System.out.println(new StatisticCourt().statistic(mole));
                        break;
                    case "regulations":
                        System.out.println(new TopRegulations().topRegulation(mole));
                        break;
                    case "jury":
                        System.out.println(new StatisticJudges().statistic(mole));
                        break;
                    case "help":
                        System.out.println(new Help().help());
                        break;
                    case "judge":
                        System.out.println("You need to enter a name of judge");
                        break;
                    case "rubrum":
                        System.out.println("You need to enter a signature of judgment");
                        break;
                    case "content":
                        System.out.println("You need to enter a signature of judgment");
                        break;


                    default:
                        break;
                }
                if (line.length() > 5)
                    if (line.substring(0, 6).equals("judge ")) {
                        String Entry = "";
                        for (int i = 6; i < line.length(); i++) Entry += line.charAt(i);
                        System.out.println(new JudgeCaseCounter().howMany(Entry,mole));
                    }
                if (line.length() > 6)
                    if (line.substring(0, 7).equals("rubrum ")) {
                        String Entry = "";
                        for (int i = 7; i < line.length(); i++) Entry += line.charAt(i); //III SA/Wa 1184/04
                        System.out.println();
                        System.out.println(new FindMore().searchForMore(Entry, mole));
                    }

                if (line.length() > 7)
                    if (line.substring(0, 8).equals("content ")) {
                        String Entry = "";
                        for (int i = 8; i < line.length(); i++) Entry += line.charAt(i);
                        System.out.println(new FindContent().searchForContent(Entry, mole));
                    }


            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());

            }


        }


    }

}
