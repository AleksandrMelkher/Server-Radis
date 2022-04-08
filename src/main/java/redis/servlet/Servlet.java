package redis.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.TreeMap;


public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter("command");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        boolean validCommand = true;
        TreeMap<String, String> mapString; //работа с объектами "string"

        StringBuilder str = new StringBuilder();
        mapString = ObjectString.getInstance().mapString;

//      В зависимости откоманды клиента выполняется необходимый запрос в хранилище и формируется ответ
        switch (command) {
            case "SET":
                mapString.put(key, value);
                str.append("ok");
                break;
            case "GET":
                str.append(mapString.get(key));
                break;
            case "DEL":
                str.append(mapString.remove(key));
                break;
            case "KEYS":
                if (key.equals("*")) {
                    for (String s : mapString.keySet()) {
                        str.append("\n");
                        str.append(s);
                    }
                }
                break;
            default:
                validCommand = false;
                break;
        }

        // Ответ возвращается клиенту
        try {
            if (validCommand) {
                str.append("\nnumber of elements ").append(mapString.size());
                str.append("\nelement type ->").append("String");
                String commandResult = str.toString();
                PrintWriter pw = response.getWriter();
                pw.println(commandResult);
            } else response.getWriter().println("invalid command");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


