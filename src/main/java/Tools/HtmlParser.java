package Tools;

import Files.ItemInside.CourtType;
import Files.ItemInside.Item;
import Files.ItemInside.Judge;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class HtmlParser {

    public void html(String path) throws IOException {


        File catalog = new File(path);
        String[] files = catalog.list();
        System.out.println(path);
        for (String name : files) {
            List<Item> items = new LinkedList<>();


            String filePath = catalog.getPath() + "/" + name;

            System.out.println(filePath);
            File file = new File(filePath);

            Document doc = Jsoup.parse(file, "UTF-8");
            Elements caseNumberHTML = doc.getElementsByClass("war_header");


            String caseNumberBuffer = caseNumberHTML.text();
            String caseNumber = caseNumberBuffer.substring(0, caseNumberBuffer.indexOf(" -"));


            Elements tableValues = doc.select("td.info-list-value");
            String judgmentDateBuffer = tableValues.get(0).text().substring(0, 10);
            String courtTypeBuffer = tableValues.get(2).text();

            CourtType type = null;

            if (courtTypeBuffer.contains("Wojewódzki Sąd Administracyjny")) type = CourtType.ADMINISTRATIVE;
            if (courtTypeBuffer.contains("Naczelny Sąd Administracyjny")) type = CourtType.SUPREMEADMINISTATIVE;

            List<Judge> judgesList = new LinkedList<>();
            String judgesTable = tableValues.get(3).outerHtml();
            System.out.println(judgesTable);

            String judgeName = "";
            String specialRoles = "";
            for (int i = 0; i < judgesTable.length(); i++) {
                if (judgesTable.charAt(i) == '<') {
                    if (!judgeName.equals("")) {
                        int nameLastIndex = judgeName.length() - 1;
                        System.out.println(judgeName);
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


            Html newHtml = new HtmlBuilder()
                    .setCourtCases(caseNumber)
                    .setJudgmentDate(judgmentDateBuffer)
                    .setCourtType(type)
                    .setJudges(judgesList)
                    .build();


            System.out.println("AS");

        }
    }

}
