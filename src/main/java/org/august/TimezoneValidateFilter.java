package org.august;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TimeZone;
import javax.servlet.annotation.WebFilter;

@WebFilter("/time")
public class TimezoneValidateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String timezone = httpRequest.getParameter("timezone");

        if (timezone == null || TimeZone.getTimeZone(timezone) == null) {
            httpResponse.setContentType("text/html; charset=utf-8");
            httpResponse.getWriter().println("Invalid timezone");
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // No-op
    }

    @Override
    public void destroy() {
        // No-op
    }
}