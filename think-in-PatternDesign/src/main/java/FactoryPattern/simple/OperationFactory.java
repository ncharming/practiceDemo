package FactoryPattern.simple;

/**
 * @Classname OperationFactory
 * @Description TODO
 * @Date 2020/10/27 21:27
 * @Created by nihongyu
 */
public class OperationFactory {

    public static Operation createOperation(String operation) {
        Operation oper = null;
        switch (operation) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OprationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }
}
