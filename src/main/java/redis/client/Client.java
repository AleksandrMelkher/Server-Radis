package redis.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String commandRequest = requestMethod();
        startGet(commandRequest);
    }

    /**
     * Метод формирует запрос http из команды от пользователя
     */
    public static String requestMethod() {
        String command = "0";
        String key = "0";
        String value = "0";
        String type = "string";
        StringBuilder str = new StringBuilder();
        String list = "0";

        String urlRedis = "http://localhost:8888/servlet";
        System.out.println("Введите команду");
        Scanner sc = new Scanner(System.in);
        String [] com = sc.nextLine().split(" ");

        int temp = 0;
        for (String s : com) {
            if (temp==0) {
                command = s; temp +=1;
            } else if(temp==1) {
                key = s; temp +=1;
            } else if (temp==2) {
                value = s; temp +=1;
            } else {
                str.append("|"); str.append(s); temp +=1;
            }
        }

        if (value.contains(":")) type = "map";
        if (str.length()!=0) {
            type = "list"; list = str.toString();
        }

        return String.format(urlRedis + "?command=%s&key=%s&value=%s&type=%s&list=%s", command, key, value, type, list);
    }


    /**
     * Метод соединения с сервером и вывода результат запроса к серверу в терминал.
     */
    public static void startGet(String urlIn) throws IOException {
        HttpURLConnection connection ;
        URL url;
        InputStreamReader inputStream = null;
        OutputStreamWriter outputStream = null;
        BufferedReader bf = null;

        try {
            url =new URL(urlIn);
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
                System.out.printf("Fail %s", connection.getResponseCode());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert bf != null;
            bf.close();
            inputStream.close();
        }
    }

}
