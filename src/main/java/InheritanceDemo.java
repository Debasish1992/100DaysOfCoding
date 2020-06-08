public class InheritanceDemo{
    String name;
    public void printMessage(String message){
        System.out.println(message);
    }
}

 class Two extends InheritanceDemo{
     int id;
     public void printMessage(String message){
        System.out.println(message);
    }
}

class A {
    public static void main(String args[]){

        // Upcasting. The superclass type to sub class type
        InheritanceDemo p = new Two();
        p.name = "GeeksforGeeks";

        // This parameter is not accessible
        // p.id = 1;
        System.out.println(p.name);
        p.printMessage("ZZZZZZZZ");
        // Trying to Downcasting Implicitly
        // Child c = new Parent(); - > compile time error
        // Downcasting Explicitly. The sub class type is casted to super class type
        Two c = (Two) p;

        c.id = 1;
        System.out.println(c.name);
        System.out.println(c.id);
        c.printMessage("XXXXXXXXXXXXXXXXX");
    }

}