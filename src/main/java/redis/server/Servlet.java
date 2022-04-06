package redis.server;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.TreeMap;


public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){

        String command = request.getParameter("command");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String type = request.getParameter("type");
        String list = request.getParameter("list");
        System.out.println(command);
        System.out.println(key);
        System.out.println(value);
        System.out.println(type);
        System.out.println(list);

        ObjectString obj = ObjectString.getInstance();
        TreeMap<String, String> mapString = obj.mapString;
        StringBuilder str = new StringBuilder();

        boolean validCommand = true;

        switch (command) {
            case "SET": mapString.put(key, value); str.append("ok"); break;
            case "GET": str.append(mapString.get(key)); break;
            case "DEL": str.append(mapString.remove(key)); break;
            case "KEYS":
                if (key.equals("*")) {

                }
                break;
            default:
                validCommand = false;
                break;
        }

        try {
            if (validCommand) {
                str.append("\nnumber of elements ").append(mapString.size());
                String commandResult = str.toString();
                PrintWriter pw = response.getWriter();
                pw.println(commandResult);
            } else response.getWriter().println("invalid command");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

