package redis.servletMap;

import redis.servletList.ObjectList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class ServletMap extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){

        String command = request.getParameter("command");
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        String keyMap = value.split(":")[0];
        String volMap = value.split(":")[1];

//        TreeMap<String, Map<String, String>> mapMap = ObjectMap.getInstance().mapMap; //работа с объектами "ObjectMap"
//        TreeMap<String, String> valueMap = new TreeMap<>();
//        valueMap.put(keyMap, volMap);

        System.out.println("command-> " + command);
        System.out.println("key-> " + key);
        System.out.println("value-> " + value);
        System.out.println("keyMap-> " + keyMap);
        System.out.println("volMap-> " + volMap);
//        System.out.println("valueMap-> " + valueMap);
    }
}

