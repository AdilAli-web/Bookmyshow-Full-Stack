public class FinallyDemo2 {
    public static void main(String[] args) {


        //try without catch --- no
        //try will not execute alone
        try {
            System.out.println("Try block");
        }
        finally {
            System.out.println("finally block");
            // cleanup code
            //connection close
        }

    }
}
