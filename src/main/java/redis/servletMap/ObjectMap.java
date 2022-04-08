package redis.servletMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ObjectMap {
    public Map<String, String> valueMap = new HashMap<>();
    public TreeMap<String, Map<String, String>> mapMap = new TreeMap<>();
    private static ObjectMap instance;
    private ObjectMap() {}

    public static ObjectMap getInstance() {
        if (instance == null) {
            instance = new ObjectMap();
        } return instance;
    }
}
