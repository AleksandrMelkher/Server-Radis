import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Client {
    public static void main(String[] args) {
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start() throws IOException {
        String urlIn = "http://localhost:8888/servlet";
        HttpURLConnection connection = null;
        URL url = null;
        InputStreamReader inputStream = null;
        BufferedReader bf = null;

        try {
            url =new URL(urlIn);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                System.out.println("Соединение установлено");
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
