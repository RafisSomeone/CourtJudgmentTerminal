package tree;

public class Regulate implements Comparable<Regulate> {

    private int counter;
    private String title;
    public Regulate(int counter, String title) {

        this.counter = counter;
        this.title=title;
    }

    public void increaseCounter() {
        counter++;
    }

    public String getTitle() {
        return title;
    }

    public int getCounter() {
        return counter;
    }



    @Override
    public int compareTo(Regulate tmp) {
        if(this.getTitle() == tmp.getTitle()) return 0;
        else if(this.getCounter()>tmp.getCounter())
            return -1;
        else return 1;

    }
}
