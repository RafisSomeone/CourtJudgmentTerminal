package Tools;

import Files.ItemInside.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class HtmlParser {

    public void html(String path, DataBase base) throws IOException {



        File catalog = new File(path);
        String[] files = catalog.list();
        List<Item> items = new LinkedList<>();
        boolean isThereHTML=false;
        for (String name : files) {



            String filePath = catalog.getPath() + "/" + name;

            if(!name.contains(".html"))continue;
            isThereHTML=true;
            System.out.println(name);
            File file = new File(filePath);

            Document doc = Jsoup.parse(file, "UTF-8");

            //CaseNumber
            Elements caseNumberHTML = doc.getElementsByClass("war_header");
            String caseNumberBuffer = caseNumberHTML.text();
            String caseNumber = caseNumberBuffer.substring(0, caseNumberBuffer.indexOf(" -"));


            Elements tableValues = doc.select("td.info-list-value");

            //Date
            String judgmentDateBuffer = tableValues.get(0).text().substring(0, 10);

            //CourtType
            String courtTypeBuffer = tableValues.get(2).text();

            CourtType type = null;

            if (courtTypeBuffer.contains("Wojewódzki Sąd Administracyjny")) type = CourtType.ADMINISTRATIVE;
            if (courtTypeBuffer.contains("Naczelny Sąd Administracyjny")) type = CourtType.SUPREMEADMINISTATIVE;
            //Judges
            List<Judge> judgesList = new LinkedList<>();
            String judgesTable = tableValues.get(3).outerHtml();


            String judgeName = "";
            String specialRoles = "";
            for (int i = 0; i < judgesTable.length(); i++) {
                if (judgesTable.charAt(i) == '<') {
                    if (!judgeName.equals("")) {
                        int nameLastIndex = judgeName.length() - 1;

                        while (judgeName.charAt(nameLastIndex) == ' ') {    //cleaning the name
                            judgeName = judgeName.substring(0, nameLastIndex);
                            nameLastIndex = judgeName.length() - 1;
                        }
                        if (judgeName.charAt(0) == ' ') judgeName = judgeName.substring(1);
                        if (specialRoles.equals("")) judgesList.add(new Judge(judgeName, "")); // saving judge
                        else judgesList.add(new Judge(judgeName, specialRoles));

                    }
                    judgeName = "";
                    specialRoles = "";
                    while (judgesTable.charAt(i) != '>') i++; //skipping <.>
                }
                if (judgesTable.charAt(i) != '>') {
                    if (judgesTable.charAt(i) != '/') judgeName += judgesTable.charAt(i); // getting name


                }
                if (judgesTable.charAt(i) == '/') {
                    i++;
                    while (judgesTable.charAt(i) != '/') {
                        specialRoles += judgesTable.charAt(i); //getting specialRoles
                        i++;
                    }
                }
            }

            //TextContent
            Elements textContentHtml = doc.select("span.info-list-value-uzasadnienie");
            Elements verses = textContentHtml.select("p");
            String textContent="UZASADNIENIE\n";
            for(Element oneVerse : verses)
            {
                textContent+=oneVerse.text()+'\n';
            }

            //referencedRegulations
            List<Referenced> referencedRegulationsList = new LinkedList<>();
            Elements referencedRegulations = doc.select("span.nakt");
            for(Element regulation : referencedRegulations)
            {   String cleanRegulation= regulation.text();
                if(cleanRegulation.contains("tekst jednolity")) cleanRegulation=cleanRegulation.substring(0,cleanRegulation.indexOf("tekst jednolity"));

                int lastChar=cleanRegulation.length()-1;
                while(cleanRegulation.charAt(lastChar)==' ' || cleanRegulation.charAt(lastChar)=='-'){cleanRegulation=cleanRegulation.substring(0,lastChar); lastChar=cleanRegulation.length()-1;}
                referencedRegulationsList.add(new Referenced(cleanRegulation));
            }





            Html newHtml = new HtmlBuilder()
                    .setCourtCases(caseNumber)
                    .setJudgmentDate(judgmentDateBuffer)
                    .setCourtType(type)
                    .setJudges(judgesList)
                    .setTextContent(textContent)
                    .setReferencedRegulations(referencedRegulationsList)
                    .build();

            items.add(newHtml.htmlToItems());



        }
        if(!isThereHTML) throw new FileNotFoundException();
        base.addToBase(new JudgeFile(items));
    }

}
