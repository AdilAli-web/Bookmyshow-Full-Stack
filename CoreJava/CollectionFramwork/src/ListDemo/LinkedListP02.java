package ListDemo;

import java.util.LinkedList;

public class LinkedListP02 {

    public static void main(String[] args) {
        LinkedList<String> BrowserHistory = new LinkedList<>();
        BrowserHistory.add("codeforsuccess.com");
        BrowserHistory.add("google.com");
        BrowserHistory.add("youtube.com");
        BrowserHistory.add("github.com");
        BrowserHistory.add("stackoverflow.com");

        System.out.println(BrowserHistory);
        System.out.println(BrowserHistory.removeFirst());
        System.out.println(BrowserHistory.removeLast());
    }
}
