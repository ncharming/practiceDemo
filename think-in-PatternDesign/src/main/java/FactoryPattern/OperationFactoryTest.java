package FactoryPattern;

import FactoryPattern.simple.*;

import java.io.Console;
import java.util.Scanner;

/**
 * @Classname OperationFactoryMain
 * @Description TODO
 * @Date 2020/10/27 21:04
 * @Created by nihongyu
 */
public class OperationFactoryTest {
    public static void main(String[] args) {

        System.out.println("请输入数字A：");
        Scanner scanner = new Scanner(System.in);
        double numA = scanner.nextDouble();
        System.out.println("请输入数字B：");
        double numB = scanner.nextDouble();
        System.out.println("请输入操作符：");
        String operation = scanner.next();

        double result = 0;
        Operation oper = null;
        oper = OperationFactory.createOperation(operation);
        oper.setNumA(numA);
        oper.setNumB(numB);
        result = oper.getResult();

        System.out.println("结果是：" + result);

    }
}
