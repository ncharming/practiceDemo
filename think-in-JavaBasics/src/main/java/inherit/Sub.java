package inherit;

/**
 * 看到的下面的代码题；在 IDEA 中直接使用 alt+enter 就可自动为你提供解决方案
 * 解决方案：
 * 1.在子类的构造函数中加上 super(str); 且这句代码必须在子类构造函数的第一行
 * 2.在父类中显示的定义一个空构造函数
 *
 * 思考：考察继承时，初始化问题
 * 前提背景：
 *      一个类中若没有显示的写构造函数，那么编译器会加上一个空的构造函数
 *      如果显示的加上非空构造函数，那么就不会加上一个空的构造函数（即，反正必须要有构造函数，有就不管，没有加加一个空的）
 * 子类初始化（给属性值赋值）之前，会先去初始化父类（就是执行构造函数：初始化类）；
 * 子类中没有显示调用的父类的构造函数，那么编译器会自动在子类构造函数中加上 super(); 语句
 * 下面这道题就是因为父类中没有默认构造函数(空构造函数)，而子类也没有显示的调用父类定义的构造函数，编译器就会加上 super();但是父类却没有，所以报错，编译不通过
 */

class Super {
    public String s = "hell";

    public Super(String str) {
        System.out.println(s);
        this.s = str;
    }
}


public class Sub extends Super {

    public Sub(String str) {
        super(str);//原
        s = "hello";
    }

    public static void main(String[] args) {
        Sub sub = new Sub("hhh");
        System.out.println(sub);
    }

}
