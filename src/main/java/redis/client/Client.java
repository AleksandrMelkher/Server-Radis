package redis.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String commandRequest = requestMethod();
//        System.out.println(commandRequest);
        startGet(commandRequest);
    }

    /**
     * Метод формирует запрос http из команды от пользователя
     */
    public static String requestMethod() {
        String command = "0";
        String key = "0";
        String value = "0";
        String list = "0";
        String type;
        String servlet = "servlet";
        String urlRedis = "http://localhost:8888/";

        StringBuilder str = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите тип (по умолчанию String).");
        type = sc.nextLine();
        System.out.println("Введите команду");
        String[] com = sc.nextLine().split(" ");

        int temp = 0;
        for (String s : com) {
            if (temp == 0) {
                command = s;
                temp += 1;
            } else if (temp == 1) {
                key = s;
                temp += 1;
            } else if (temp == 2) {
                value = s;
                temp += 1;
            } else {
                str.append("|");
                str.append(s);
                temp += 1;
            }
        }


        if (value.contains(":") || type.equals("MAP")) {
            servlet = "servletMap";
        }

        if (str.length() != 0 || type.equals("LIST")) {
            servlet = "servletList";
            list = str.toString();
        }

        return String.format(urlRedis + "%s?command=%s&key=%s&value=%s&list=%s",
                servlet, command, key, value, list);
    }


    /**
     * Метод соединения с сервером и вывода результат запроса к серверу в терминал.
     */
    public static void startGet(String urlIn) throws IOException {
        HttpURLConnection connection;
        URL url;
        InputStreamReader inputStream = null;
        BufferedReader bf = null;

        try {
            url = new URL(urlIn);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                inputStream = new InputStreamReader(connection.getInputStream());
                bf = new BufferedReader(inputStream);
                while (bf.ready()) {
                    System.out.println(bf.readLine());
                }
            } else {
                System.out.printf("Fail %s \n", connection.getResponseCode());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bf != null;
            bf.close();
            inputStream.close();
        }
    }
}
