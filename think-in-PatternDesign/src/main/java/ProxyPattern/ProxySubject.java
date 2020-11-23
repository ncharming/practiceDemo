package ProxyPattern;

public class ProxySubject implements Subject {
    @Override
    public void buyMac() {
        RealSubject realSubject = new RealSubject();//实例化一个真正想要的类
        realSubject.buyMac();//调用真实类的方法
        wrapMac();//代理类中额外的操作
    }

    public void wrapMac(){
        System.out.println("包装好 Mac");
    }

    public static void main(String[] args) {
        Subject subject=new ProxySubject();
        subject.buyMac();
    }
}
