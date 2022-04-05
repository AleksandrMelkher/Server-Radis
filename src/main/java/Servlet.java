
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int status = response.getStatus();
        Writer writer = response.getWriter();
        writer.write("server response");
        System.out.println(response.getStatus());

    }
}

