package tree;

public class JudgeNumber {

    int judgeQuantity;
    int counter;

    public JudgeNumber(int judgeQuantity,int counter)
    {
        this.judgeQuantity=judgeQuantity;
        this.counter=counter;
    }


    public int getJudgeQuantity() {
        return judgeQuantity;
    }

    public int getCounter() {
        return counter;
    }
    public void increaseCounter() {
        counter++;
    }

}
