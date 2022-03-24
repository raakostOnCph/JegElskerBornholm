import DomæneObjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TransaktionServlet", value = "/TransaktionServlet")
public class TransaktionServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String beløb = request.getParameter("value");

        Konto konto = (Konto) request.getSession().getAttribute("konto");

        int i = Integer.parseInt(beløb);


        String fejlBesked = "";

        if (i > konto.getSaldo()) {
            fejlBesked = "så mange penge har du ikke";
        }
        if(i < 0) {
            fejlBesked = "du kan ikke hæve en negativt beløb";
        }
        konto.withdraw(i);

        request.setAttribute("fejl", fejlBesked);

        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String beløb = request.getParameter("value");
        log("beløbet er " + beløb);

        Konto konto = (Konto) request.getSession().getAttribute("konto");

        int i = Integer.parseInt(beløb);

        String fejlBesked = "";

        if (i < 0) {
            fejlBesked = "du ikke indsætte et negativt beløb";

        }
        konto.insert(i);

        request.setAttribute("fejl", fejlBesked);
        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);

    }
}
