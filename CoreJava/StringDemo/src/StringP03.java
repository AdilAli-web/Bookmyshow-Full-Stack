
public class StringP03 {
    public static void main(String[] args) {
        String s1="java";
        String s2="java";

        System.out.println(s1==s2); //true

        String s3=new String("java");
        String s4=new String("java");

        System.out.println(s1==s3);
        System.out.println(s3==s4);
    }
}
