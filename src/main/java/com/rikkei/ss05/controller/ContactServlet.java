package com.rikkei.ss05.controller;

import com.rikkei.ss05.model.Contact;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ContactServlet", value = "/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final List<Contact> contacts = new ArrayList<>();
    private static int idCounter = 1;

    private Contact getContactById(int id) {
        return contacts.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            request.getRequestDispatcher("/view/Bai10/addContact.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Contact contact = getContactById(id);
            request.setAttribute("contact", contact);
            request.getRequestDispatcher("/view/Bai10/editContact.jsp").forward(request, response);
        } else {
            request.setAttribute("contacts", contacts);
            request.getRequestDispatcher("/view/Bai10/contactList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            Contact contact = new Contact(
                    idCounter++,
                    request.getParameter("firstName"),
                    request.getParameter("lastName"),
                    request.getParameter("email"),
                    request.getParameter("phone")
            );
            contacts.add(contact);
            response.sendRedirect(request.getContextPath() + "/ContactServlet");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Contact contact = getContactById(id);
            if (contact != null) {
                contact.setFirstName(request.getParameter("firstName"));
                contact.setLastName(request.getParameter("lastName"));
                contact.setEmail(request.getParameter("email"));
                contact.setPhone(request.getParameter("phone"));
            }
            response.sendRedirect(request.getContextPath() + "/ContactServlet");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            contacts.removeIf(c -> c.getId() == id);
            response.sendRedirect(request.getContextPath() + "/ContactServlet");
        }
    }
}