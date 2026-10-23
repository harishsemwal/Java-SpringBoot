package org.codeArmy.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // Request log
        System.out.println("Incoming Request : " + httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);

        // Response Status
        System.out.println("Response Status : " + httpServletResponse.getStatus());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
