package tree;

public class Month {


    private Months month;
    private int counter;


    public Month(Months month,int counter){

        this.month=month;
        this.counter=counter;
    }


    public Months getMonth() {
        return month;
    }

    public int getCounter() {
        return counter;
    }

    public void increaseCounter() {
        counter++;
    }
}
