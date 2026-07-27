package ListDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListP01 {
    public static void main(String[] args) {
        List<String> playList= new ArrayList<>();

        playList.add("video: 1");
        playList.add("video: 2");
        playList.add("video: 3");
        playList.add("video: 1");

        System.out.println(playList);

        System.out.println(playList.get(0));

    }
}
