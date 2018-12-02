package Kernel;

import Tools.EntryConverter;
import Tools.Researcher;

import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {


        Researcher mole = new Researcher();
        mole.load("C:\\Users\\rafal\\IdeaProjects\\CourtJudgmentTerminal\\src\\main\\resources");


        EntryConverter hammer = new EntryConverter();
        int[] Entry = hammer.convert("153/2003");
        System.out.println(mole.searchFor("153/2003/1503"));
        // mole.searchFor(new EntryConverter().convert("11/"))
        System.out.println(Entry[0]);
        System.out.println(Entry[1]);
        System.out.println(Entry[2]);

    }


}
