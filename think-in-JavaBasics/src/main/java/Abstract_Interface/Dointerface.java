package Abstract_Interface;

public class Dointerface extends MockInteface {
    @Override
    public void functiona() {
        System.out.println("相当于使用类实现了接口");
    }

    public static void main(String[] args) {
        MockInteface dointerface = new Dointerface();
        dointerface.functiona();
    }
}
