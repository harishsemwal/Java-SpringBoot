package org.codeArmy.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
public class ResponseBodyWrapper implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper(httpServletResponse);

        filterChain.doFilter(servletRequest, contentCachingResponseWrapper);
        byte[] originalByte = contentCachingResponseWrapper.getContentAsByteArray();

        String originalBody = new String(originalByte);

        String modifiedBody = """
                {
                "originalResponse" :  %s,
                "appName" : "Student Management System
                }
                """.formatted(originalBody);

        contentCachingResponseWrapper.resetBuffer();

        contentCachingResponseWrapper.getWriter().write(modifiedBody);

        contentCachingResponseWrapper.copyBodyToResponse();

    }
}
