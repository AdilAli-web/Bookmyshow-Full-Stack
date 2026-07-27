public class Babu {

    void sorry(String name)
    {
        System.out.println(name + " sorry bolo....");
    }

    void add(int a ,int b)
    {
        System.out.println("sum of two numbers "+(a+b));
    }


    public static void main(String[] args) {
        Babu b= new Babu();
        b.sorry("Hariya");

        b.add(30,20);
    }
}
