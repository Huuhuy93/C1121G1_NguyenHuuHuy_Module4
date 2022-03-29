package controller;

import model.Sach;
import service.ISachService;
import service.SachService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "C11Servlet", value = "/sach")
public class ThuVienServlet extends HttpServlet {
    ISachService iSachService = new SachService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "createCustomer":
                    showNewSachForm(request, response);
                    break;
                default:
                    listSachDTO(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listSachDTO(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {
        List<Sach> sachList = iSachService.selectAllSach();
        request.setAttribute("sachList", sachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sach/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewSachForm(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "createCustomer":
                    insertSach(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertSach(HttpServletRequest request, HttpServletResponse response) throws SQLException,
            ServletException, IOException {
    }
}
