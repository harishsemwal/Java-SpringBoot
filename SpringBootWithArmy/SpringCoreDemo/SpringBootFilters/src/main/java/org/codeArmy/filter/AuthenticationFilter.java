package org.codeArmy.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Long startTime = System.currentTimeMillis();

        String requestId = UUID.randomUUID().toString();

        httpServletResponse.setHeader("X-RequestId", requestId);

        String token = httpServletRequest.getHeader("token");
        String apiKey = httpServletRequest.getHeader("x-api-key");
        if (token == null || !token.equals("12345")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.getWriter().write("Unauthorized: Invalid User");
            return;
        }

        if (apiKey == null || !apiKey.equals("secret123")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.getWriter().write("Unauthorized: Invalid User");
            return;
        }

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("API Response Time: " + duration + "ms.");
        }

    }
}
