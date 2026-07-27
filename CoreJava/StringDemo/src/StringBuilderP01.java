public class StringBuilderP01 {
    public static void main(String[] args) {

        String s1="Raju";
        StringBuilder sb= new StringBuilder("Java");

      /*  sb.append(" Backend");
        sb.append(" Course Demo class");*/

        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        //default capacity: 16
        //formula =old cap *2 +2
    }
}
