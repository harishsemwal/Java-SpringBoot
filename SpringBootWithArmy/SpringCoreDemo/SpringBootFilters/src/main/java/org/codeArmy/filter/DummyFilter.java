package org.codeArmy.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DummyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String URI = httpServletRequest.getRequestURI();

        if(!URI.startsWith("/api/")){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        System.out.println("Dummy Filter called");

    }
}
