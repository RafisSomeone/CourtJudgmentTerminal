package Tools;

import Files.ItemInside.Files;

import java.util.List;

public class Researcher extends Loader{
    public Researcher()
    {

    }


   public String searchFor(String Entry) {
       for (Files chosenOne : loadedFiles) {

         String allert =chosenOne.searchFor(Entry);
           if(!allert.equals("Nie ma"))return allert;

       }
return "Nie ma";

   }

}
