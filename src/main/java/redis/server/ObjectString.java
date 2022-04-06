package redis.server;

import java.util.TreeMap;

class ObjectString {
    public TreeMap<String, String> mapString = new TreeMap<>();
    private static ObjectString instance;
    private ObjectString() {}

    public static ObjectString getInstance() {
        if (instance == null) {
            instance = new ObjectString();
        } return instance;
    }
}
