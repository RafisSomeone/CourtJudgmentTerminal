package Kernel;

import Tools.EntryConverter;
import Tools.Loader;


import java.io.FileNotFoundException;

public class Main {


    public static void main (String[] args) throws FileNotFoundException {



      Loader pioneer = new Loader("C:\\Users\\rafal\\IdeaProjects\\CourtJudgmentTerminal\\src\\main\\resources");
       pioneer.load();

        EntryConverter hammer = new EntryConverter();
        int[] Entry=hammer.convert("10/1221/3131");



    }





}
