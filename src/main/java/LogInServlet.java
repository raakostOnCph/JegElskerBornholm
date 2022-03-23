import DomæneObjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String navn = request.getParameter("navn");
        String kode = request.getParameter("kode");

        Map<String , Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("kontis");

        Konto konto = kontoMap.getOrDefault(navn, null);

        if (konto == null) {

            request.setAttribute("fejl", "kontoen fandtes ikke !");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        if (!konto.getKode().equals(kode)) {

            request.setAttribute("fejl", "den angivendendenene er forkert !");
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
