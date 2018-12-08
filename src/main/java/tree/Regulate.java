package tree;

public class Regulate implements Comparable<Regulate> {
    private String signature;
    private int counter;
    private String title;
    public Regulate(String signature, int counter, String title) {
        this.signature =signature ;
        this.counter = counter;
        this.title=title;
    }

    public void increaseCounter() {
        counter++;
    }

    public String  getSignature() {
        return signature;
    }

    public int getCounter() {
        return counter;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Regulate tmp) {
        if(this.getSignature() == tmp.getSignature()) return 0;
        else if(this.getCounter()>tmp.getCounter())
            return -1;
        else return 1;

    }
}
