package es.albarregas.controllers;

import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IProfesorDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.modelo.Direccion;
import es.albarregas.modelo.Libro;
import es.albarregas.modelo.Persona;
import es.albarregas.modelo.Profesor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Controlador", urlPatterns = {"/control"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IProfesorDAO adao = daof.getProfesorDAO();
        IGenericoDAO gdao = daof.getGenericoDAO();
        Profesor profesor = new Profesor();

        String url = null;
        switch (request.getParameter("op")) {
            case "add":
                Profesor profesor2 = new Profesor(1, "rafa", "retamal", "donoso");
                Direccion direccion = new Direccion(1, "avenida de america", 41, "almendralejo", "badajoz");
                profesor2.setDireccion(direccion);
                // gdao.add(persona);
                gdao.add(profesor2);

                Profesor profesor21 = new Profesor(12, "jesus", "noseque", "nosecuanto");
                Direccion direccion1 = new Direccion(12, "plaza", 33, "merida", "badajoz");
                direccion1.setProfesor(profesor21);
                gdao.add(direccion1);
                url = "index.html";
                break;
            case "delete":
//                profesor = adao.getOne(Integer.parseInt(request.getParameter("registro")));
//                adao.delete(profesor);
                profesor = adao.getOne(Integer.parseInt(request.getParameter("registro")));
                gdao.delete(profesor);
                url = "index.html";
                break;
            case "update":
                profesor = adao.getOne(Integer.parseInt(request.getParameter("registro")));
                request.setAttribute("profesor", profesor);
                url = "JSP/formularioActualizar.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
