package Tools;

public class EntryConverter {

    public EntryConverter(){ }

    public int[] convert(String metrics)
    {   int[] Entry = new int [3];
        int begin=0;
        int end = 0;
        int counter=0;
        for(int i=0;i<metrics.length();i++)
        {
            if(metrics.charAt(i)=='/') {
                String a = metrics.substring(begin, i);
                begin =3;
                end = i+1;
               Entry[counter]=Integer.parseInt(a);
               counter++;
            }

        }
        Entry[counter]=Integer.parseInt(metrics.substring(end));

        return Entry;

    }

}
