package redis.servletList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;


public class ServletList extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){

        String command = request.getParameter("command");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String type = request.getParameter("type");
        String list = request.getParameter("list");


        TreeMap<String, ArrayList<String>>mapList = null; //работа с объектами "string"

        if(type.equals("list")) {
            mapList = ObjectList.getInstance().mapList;
            StringBuilder str = new StringBuilder();
            boolean validCommand = true;

            // В зависимости откоманды клиента выполняется необходимый запрос в хранилище и формируется ответ
//        switch (command) {
//            case "SET": mapList.put(key, value); str.append("ok"); break;
//            case "GET": str.append(mapList.get(key)); break;
//            case "DEL": str.append(mapList.remove(key)); break;
//            case "KEYS":
//                if (key.equals("*")) {
//                    for (String s : mapList.keySet()) {
//                        str.append("\n"); str.append(s);
//                    }
//                }
//                break;
//            default:
//                validCommand = false;
//                break;
//        }

            // Ответ возвращается клиенту
//            try {
//                if (validCommand) {
//                    str.append("\nnumber of elements ").append(mapList.size());
//                    String commandResult = str.toString();
//                    PrintWriter pw = response.getWriter();
//                    pw.println(commandResult);
//                } else response.getWriter().println("invalid command");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}

