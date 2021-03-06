package Files.ItemInside;

import tree.*;

import java.util.List;
import java.util.Set;

public class JudgeFile {

    private List<Item> items;

    public JudgeFile(List<Item> items){
        this.items=items;

    }


    public String searchFor(String Entry) {

        for (Item chosenOne : items) {
            String wanted = chosenOne.searchFor(Entry);
            if (wanted != null) return wanted;

        }
        return null;


    }

    public String searchForContent(String Entry) {

        for (Item chosenOne : items) {
            String wanted = chosenOne.searchForContent(Entry);
            if (wanted != null) return wanted;

        }
        return null;


    }

    public int howMany(String name) {
        int counter = 0;

        for (Item chosenOne : items) {

            counter = counter + chosenOne.howMany(name);
        }
        return counter;


    }

    public void top(Set<JudgeValue> judge)
    {
        for(Item chosenOne : items)
        {
            chosenOne.top(judge);
        }


    }

    public void statisticSentence(List<Month> year)
    {
        for(Item chosenOne : items)
        {
            chosenOne.statisticSentence(year);

        }
    }

    public void statisticCourt(List<Court> courts)
    {
        for(Item chosenOne : items)
        {
            chosenOne.statisticCourt(courts);

        }
    }

    public void topRegulation(List<Regulate> regulations)
    {
        for(Item item:items)
        {
            item.topRegulation(regulations);
        }
    }


    public void statisticJudges(List<JudgeNumber> judgeNumbers) {
        for(Item item:items)
        {
            item.statisticJudges(judgeNumbers);
        }
    }
}

