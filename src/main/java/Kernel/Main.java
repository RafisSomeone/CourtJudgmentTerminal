package Kernel;

import Files.ItemInside.Judge;
import Tools.EntryConverter;
import Tools.Researcher;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {


    public  static void main(String[] args) throws IOException {


        Researcher mole = new Researcher();
        mole.load("C:\\Users\\rafal\\IdeaProjects\\CourtJudgmentTerminal\\src\\main\\resources");


        EntryConverter hammer = new EntryConverter();
        int[] Entry = hammer.convert("43/1964/296");
        System.out.println(mole.searchFor("43/1964/296"));
        // mole.searchFor(new EntryConverter().convert("11/"))
        System.out.println(Entry[0]);
        System.out.println(Entry[1]);
        System.out.println(Entry[2]);

        String out ="MAMA";

        TerminalEmulator terminal = new TerminalEmulator();




    }


}
