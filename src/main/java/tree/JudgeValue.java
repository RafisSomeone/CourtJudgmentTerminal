package tree;

import Files.ItemInside.Judge;

import java.util.Comparator;

public class JudgeValue implements Comparable<JudgeValue> {

   private String name;
    private int coutner;
   public JudgeValue (String name,int c)
   {
       this.coutner= c;
       this.name=name;
   }

    public int getCoutner() {
        return coutner;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.coutner + this.name;
    }

    public void increaseCounter ()
    {
        this.coutner++;

    }



    @Override
    public int compareTo(JudgeValue tmp) {
       if(this.getName() == tmp.getName()) return 0;
       else if(this.getCoutner()>tmp.getCoutner())
           return -1;
           else return 1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        JudgeValue that = (JudgeValue) o;

        if ( that.getName() == this.getName()) return true;
        else return false;

    }
}
