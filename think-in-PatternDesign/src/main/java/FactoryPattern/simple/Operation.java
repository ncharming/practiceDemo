package FactoryPattern.simple;

/**
 * @Classname Operation
 * @Description TODO
 * @Date 2020/10/27 21:06
 * @Created by nihongyu
 */
public abstract class Operation {
    private double numA=0;
    private double numB=0;

    public abstract double getResult();

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }
}
