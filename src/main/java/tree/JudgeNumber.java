package tree;

public class JudgeNumber implements Comparable<JudgeNumber>{

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
    @Override
    public int compareTo(JudgeNumber tmp) {
        if(this.getJudgeQuantity() == tmp.getJudgeQuantity()) return 0;
        else if(this.getJudgeQuantity()>tmp.getJudgeQuantity())
            return 1;
        else return -1;

    }
}
