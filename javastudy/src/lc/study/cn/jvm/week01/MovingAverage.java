package lc.study.cn.jvm.week01;

/**
 * 移动平均数移动平均数
 * @author lichao
 *
 */
public class MovingAverage {
    private int count = 0;
    private double sum = 0.0D;

    public void submit (double value){
        this.count++;
        this.sum += value;
    }

    public double getAvg (){
        return this.count == 0 ? this.sum : sum/count;
    }

}
