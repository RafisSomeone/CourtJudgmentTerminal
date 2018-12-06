package Tools;

public class Converter {

    public Converter() {
    }

    public int[] convert1(String metrics) {
        int[] Entry = new int[3];
        int begin = 0;
        int counter = 0;
        for (int i = 0; i < metrics.length(); i++) {
            if (metrics.charAt(i) == '/') {
                String a = metrics.substring(begin, i);
                begin = i + 1;

                Entry[counter] = Integer.parseInt(a);
                counter++;
            }

        }
        Entry[counter] = Integer.parseInt(metrics.substring(begin));

        return Entry;

    }

    public String clean(String outCome) {
        String cleanOutCome = "";
        int i = outCome.indexOf("UZASADNIENIE");
        while (outCome.length() > i) {
            if (outCome.charAt(i) != '<') cleanOutCome = cleanOutCome + outCome.charAt(i);
            else while (outCome.charAt(i) != '>') i++;

            i++;
        }

        return cleanOutCome;

    }

}
