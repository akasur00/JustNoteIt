package de.thb.justnoteit.controller;

import de.thb.justnoteit.entity.Notebook;
import de.thb.justnoteit.service.DeskService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/NotebookController")
public class NotebookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DeskService deskService;
    public NotebookController(){
        super();
        deskService = new DeskService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("\r\nMeine Notizbücher:\r\n");

        Enumeration parameters = request.getParameterNames();
        String parameter = request.getParameter("id");
        String parameterNotes = request.getParameter("Notes");

        if (parameter == null){
            List<Notebook> notebookList = deskService.getAllNotebooks();
            for (Notebook notebook : notebookList) {
                response.getWriter()
                        .append(notebook.getId() + "- " + notebook.getName() + "\r\n");
            }
        } else {

            try {
                List<Notebook> notebookList = deskService.getAllNotebooks();
                response.getWriter()
                        .append(deskService
                                .getNotebook(Long.parseLong(parameter))
                                .toString());
            } catch (NullPointerException e) {
                response.getWriter().append("Das Notebook existiert nicht: \n");
                response.getWriter().append(e.getMessage());
            }

        }
    }
}
