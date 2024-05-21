package org.august;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String timezone = req.getParameter("timezone");
        ZoneId zoneId = timezone != null ? ZoneId.of(timezone) : ZoneId.of("UTC");
        ZonedDateTime now = ZonedDateTime.now(zoneId);

        resp.getWriter().println("<!DOCTYPE html>");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<title>Current Time</title>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("Current time: " + now.toString());
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }
}