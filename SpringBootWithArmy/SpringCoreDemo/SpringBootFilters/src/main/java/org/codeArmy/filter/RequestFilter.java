package org.codeArmy.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hamcrest.Condition;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

//@Component
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String token = httpServletRequest.getHeader("token");

//        httpServletRequest.getInputStream();
        BufferedReader bufferedReader = httpServletRequest.getReader();

        StringBuilder stringBuilderBody = new StringBuilder();

        String line = bufferedReader.readLine();

        while (line != null){
            stringBuilderBody.append(line);
            line = bufferedReader.readLine();
        }

        System.out.println(stringBuilderBody);

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
