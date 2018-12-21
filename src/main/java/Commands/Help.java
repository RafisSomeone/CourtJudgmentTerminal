package Commands;

public class Help {


    public String help(){
        return "\n" +
                "    rubrum [courtCases,courtCases,...] - displays rubrum for one or more cases \n" +
                "    content [courtCases] - displays content of the case \n" +
                "    judge [judgeName] - displays  number of judgments for selected judge \n" +
                "    judges - displays top 10 judges,who participated in the largest number of judgments \n" +
                "    months - displays the statistical distribution of judgments in each month\n" +
                "    courts - displayed the number of judgments by the type of court \n" +
                "    regulations - displays top 10 most referenced regulations\n" +
                "    jury -displays statistic on number of judges attached to the cases\n";




    }


}
