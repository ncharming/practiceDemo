package inherit;

/** 最终 a 变量的取值是多少？
 * 执行顺序：
 * 1.先执行 Base() 构造函数
 * 2.调用 preProcess 函数没有调用父类的，而是直接调用子类的（因为 Drived drived = new Drived();new 的子类）
 * 3.父类走完后继续走子类的构造函数
 * 4.在走子类构造函数之前，会先给定义的变量赋值，再继续走子类的构造函数
 *
 */
public class Base {
    public Base() {
        preProcess();
    }

    void preProcess() {
        System.out.println("base preProcess");
    }
}

class Drived extends Base {
    /**
     * 变量初始化和构造函数执行顺序：变量先初始化，再运行构造函数
     */
    public String a = "drived ";

    public Drived(){
        System.out.println("drived preProcess");
    }

    @Override
    void preProcess() {
        a = "drived method";
    }

    public static void main(String[] args) {
        Drived drived = new Drived();
        System.out.println(drived.a);
    }
}
