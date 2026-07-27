public class StringConversion {
    public static void main(String[] args) {

        String ageText="22";
        String priceText="99.66";
        String activeText="true";
        String value="abc";

        //int n1=Integer.parseInt(value);

        int age=Integer.parseInt(ageText);
        double price=Double.parseDouble(priceText);
        boolean active=Boolean.parseBoolean(activeText);

        System.out.println(age);
        System.out.println(price);
        System.out.println(active);
    }
}
