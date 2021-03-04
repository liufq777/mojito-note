package com.mojito.note;

import com.mojito.note.config.CorsFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

/**
 * @author liufengqiang
 * @date 2020-12-10 18:36:03
 */
@SpringBootApplication
@MapperScan("com.mojito.note.mapper")
public class MojitoNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MojitoNoteApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();
        bean.addUrlPatterns("/*");
        bean.setFilter(new CorsFilter());
        // 过滤顺序，从小到大依次过滤
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
