package ProxyPattern;

public class RealSubject implements Subject {
    @Override
    public void buyMac() {
        System.out.println("真实的是：买一个 Mac！");
    }

}
