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

            request.setAttribute("fejl", "Koden var  forkert !");
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }
        // det når vi hvis det lykkedes

        HttpSession session = request.getSession();
        session.setAttribute("konto", konto);
        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String navn = request.getParameter("navn");

        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("kontis");

        if (kontoMap.containsKey(navn)) {

            request.setAttribute("fejl", "navnet " + navn + " er allerede i brug");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        String kode = request.getParameter("kode");
        String kode1 = request.getParameter("kode1");

        if (!kode.equals(kode1)) {

            request.setAttribute("fejl", "de passwords er ikke ens");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

        Konto konto = new Konto(navn,kode,0);
        kontoMap.put(konto.getNavn(),konto);

        request.getRequestDispatcher("index.jsp").forward(request,response);




    }
}
