package FactoryPattern.simple;

/**
 * @Classname OperationDiv
 * @Description TODO
 * @Date 2020/10/27 21:10
 * @Created by nihongyu
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if(getNumB()!=0){
            return getNumA()/getNumB();
        }
        throw new IllegalArgumentException("除数不能为0");
    }
}
