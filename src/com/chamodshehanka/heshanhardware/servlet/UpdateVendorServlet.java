package com.chamodshehanka.heshanhardware.servlet;

import com.chamodshehanka.heshanhardware.controller.VendorController;
import com.chamodshehanka.heshanhardware.model.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chamodshehanka on 5/15/2019
 * @project HeshanHardware
 **/
@WebServlet(name = "UpdateVendorServlet", urlPatterns = "/UpdateVendor")
public class UpdateVendorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vendorID = request.getParameter("vendorID");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");

        boolean isUpdated = VendorController.updateVendor(new Vendor(vendorID,name,type,phone,email));

        if (isUpdated){
            request.getRequestDispatcher("/manage-vendor.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/manage-vendor.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
