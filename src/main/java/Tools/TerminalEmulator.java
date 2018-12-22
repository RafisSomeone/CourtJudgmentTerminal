package Tools;


import Commands.*;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

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

        String line;
        boolean isJsonLoaded = false;
        while (!isJsonLoaded) {
            System.out.println("Enter the path to the directory with JSON files");
            line = reader.readLine(prompt);
            try {

                mole.load(line); ///home/rafal/Dokumenty/intellij/IdeaProjects-20181219T161811Z-001/IdeaProjects/CourtJudgmentTerminal/src/main/resources/json
                isJsonLoaded = true;

            } catch (NullPointerException ex) {
                System.out.println(line + " is not a path");

            } catch (FileNotFoundException ex) {
                File json = new File(line);

                System.out.println("There is no JSON files in directory " + json.getName());


            }

        }

        boolean isHtmlLoaded = false;
        while (!isHtmlLoaded) {
            System.out.println("Enter the path to the directory with HTML files");
            line = reader.readLine(prompt);
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
        boolean recordingClerk = false;
        File clerk;
        PrintWriter printer = null;
        while (true) {
            System.out.println("Do you want to use your personal recording clerk? [y/n]");
            line = reader.readLine(prompt);
            if (line.equals("y")) {
                recordingClerk = true;
                break;
            }
            if (line.equals("n")) break;
            else System.out.println("You have to answer that question , please select \"y\" or \"n\" ");
        }

        if (recordingClerk) {
            while (true) {
                System.out.println("Enter the name of the file where your data will be written");
                String name = reader.readLine(prompt);
                System.out.println("Enter the path to the directory where your file "+name+" will be created");
                try {
                    String path = reader.readLine(prompt);
                    clerk = new File(path + "/"+name+ ".txt");
                    clerk.createNewFile();

                    System.out.println(clerk.getPath());
                    printer = new PrintWriter(clerk);
                    break;
                } catch (Exception ex) {
                    System.out.println("Incorrect path");
                }
            }
        }

        while (true) {

            try {

                line = reader.readLine(prompt);
                line = line.trim();

                boolean write=false;
                String outCome = null;
                switch (line) {
                    case "judges":
                        outCome = new TopJudges().top10(mole);
                        write=true;
                        break;
                    case "months":
                        outCome = new StatisticSentence().statistic(mole);
                        write=true;
                        break;
                    case "courts":
                        outCome = new StatisticCourt().statistic(mole);
                        write=true;
                        break;
                    case "regulations":
                        outCome = new TopRegulations().topRegulation(mole);
                        write=true;
                        break;
                    case "jury":
                        outCome = new StatisticJudges().statistic(mole);
                        write=true;
                        break;
                    case "help":
                        outCome = new Help().help();
                        write=true;
                        break;
                    case "judge":
                        outCome = "You need to enter a name of judge";
                        break;
                    case "rubrum":
                        outCome = "You need to enter a signature of judgment";
                        break;
                    case "content":
                        outCome = "You need to enter a signature of judgment";
                        break;
                    default:
                        break;
                }
                if (line.length() > 5)
                    if (line.substring(0, 6).equals("judge ")) {
                        String Entry = "";
                        for (int i = 6; i < line.length(); i++) Entry += line.charAt(i);
                        outCome=new JudgeCaseCounter().howMany(Entry, mole);
                        write=true;
                    }
                if (line.length() > 6)
                    if (line.substring(0, 7).equals("rubrum ")) {
                        String Entry = "";
                        for (int i = 7; i < line.length(); i++) Entry += line.charAt(i); //III SA/Wa 1184/04

                       outCome="\n"+new FindMore().searchForMore(Entry, mole);
                        write=true;
                    }

                if (line.length() > 7)
                    if (line.substring(0, 8).equals("content ")) {
                        String Entry = "";
                        for (int i = 8; i < line.length(); i++) Entry += line.charAt(i);
                        outCome=new FindContent().searchForContent(Entry, mole);
                        write=true;
                    }

                if (outCome != null) System.out.println(outCome);
                if (recordingClerk && write) {
                    printer.println("Command: "+line+"\n");
                    printer.println("Out come:"+outCome);
                    printer.flush();
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());

            }


        }

    }

}
