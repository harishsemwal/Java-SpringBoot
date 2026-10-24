package org.codeArmy.config;

import org.codeArmy.filter.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean() {
        FilterRegistrationBean<DummyFilter> registrationBean =
                new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());
//        registrationBean.setOrder();

        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }

}
