package Tools;



import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class TerminalEmulator {


    public void terminal () throws IOException {

        String prompt = "prompt> ";

        Terminal terminal = (Terminal) TerminalBuilder.builder()
                .system(true)
                .build();
        LineReader reader = LineReaderBuilder.builder()
                .terminal((org.jline.terminal.Terminal) terminal)
                .build();

        while(true)
        {
            String line=null;
            try{

                line = reader.readLine(prompt);
                switch(line){
                    case "asd":
                    System.out.println("asdasd");
                    case "krowa":
                        System.out.println("asdasfasdfasdfasdfasdfasdfasdfsd");


                }

            }catch (Exception ex){

            }


        }



    }

}
