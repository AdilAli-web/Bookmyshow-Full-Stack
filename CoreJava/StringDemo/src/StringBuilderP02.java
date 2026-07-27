public class StringBuilderP02 {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder("Java");

        sb.append(" Backend");
        System.out.println(sb);

        sb.insert(4," FullStack");
        System.out.println(sb);

        sb.delete(4,14);
        System.out.println(sb);

        sb.replace(5,12,"Spring");
        System.out.println(sb);

        String res=sb.toString();
        System.out.println(res);
    }
}
