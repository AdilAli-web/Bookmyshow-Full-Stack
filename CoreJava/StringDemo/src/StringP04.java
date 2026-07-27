public class StringP04 {
    public static void main(String[] args) {

        String a="java";
        String b="java";
        String c=new String("java");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a.equals(c));
    }
}
