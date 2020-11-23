package FactoryPattern.simple;

/**
 * @Classname OperationSub
 * @Description TODO
 * @Date 2020/10/27 21:09
 * @Created by nihongyu
 */
public class OperationSub extends Operation{
    @Override
    public double getResult() {
        return getNumA()-getNumB();
    }
}
