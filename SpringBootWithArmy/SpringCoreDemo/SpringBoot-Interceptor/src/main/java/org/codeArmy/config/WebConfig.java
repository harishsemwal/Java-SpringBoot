package org.codeArmy.config;

import org.codeArmy.interceptor.AuthenticationInterceptor;
import org.codeArmy.interceptor.AuthorizationInterceptor;
import org.codeArmy.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;

    public AuthenticationInterceptor authenticationInterceptor;

    public AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor, AuthenticationInterceptor authenticationInterceptor, AuthorizationInterceptor authorizationInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/admin/**").order(1);

        interceptorRegistry.addInterceptor(authenticationInterceptor).order(2);

        interceptorRegistry.addInterceptor(authorizationInterceptor).order(3);
    }
}
