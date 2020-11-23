package FactoryPattern.simple;

/**
 * @Classname OperationAdd
 * @Description TODO
 * @Date 2020/10/27 21:07
 * @Created by nihongyu
 */
public class OperationAdd extends Operation {


    @Override
    public double getResult() {
        return getNumA()+getNumB();
    }
}
