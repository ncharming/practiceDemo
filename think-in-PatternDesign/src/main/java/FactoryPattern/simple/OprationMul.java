package FactoryPattern.simple;

/**
 * @Classname OprationMul
 * @Description TODO
 * @Date 2020/10/27 21:10
 * @Created by nihongyu
 */
public class OprationMul extends Operation {
    @Override
    public double getResult() {
        return getNumA()*getNumB();
    }
}
