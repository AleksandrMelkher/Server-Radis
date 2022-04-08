package redis.servletList;

import java.util.ArrayList;
import java.util.TreeMap;

public class ObjectList {
    public TreeMap<String, ArrayList<String>> mapList = new TreeMap<>();
    private static ObjectList instance;
    private ObjectList() {}

    public static ObjectList getInstance() {
        if (instance == null) {
            instance = new ObjectList();
        } return instance;
    }
}
