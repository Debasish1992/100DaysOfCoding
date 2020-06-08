public class ImplementationClass extends AbstractClassExp {
    @Override
    void getData(int value) {
        System.out.println("The retrived value from abstract method is "+value);
    }
}

class newCall{
    public static void main(String[] args) {
        ImplementationClass implementationClass = new ImplementationClass();
        int value = implementationClass.getValueFromData();
        System.out.println("The retrived value is "+value);
        implementationClass.getData(50);
    }
}
