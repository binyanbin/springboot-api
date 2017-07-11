package com.yanbin.config;

import com.yanbin.filter.AccessInterceptor;
import com.yanbin.filter.DuplicationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yanbin on 2017/7/5.
 * mvc配置
 */
@Configuration
public class WebConfig extends  WebMvcConfigurerAdapter {

    private  AccessInterceptor accessInterceptor;
    private DuplicationInterceptor duplicationInterceptor;

    @Autowired
    public WebConfig(AccessInterceptor accessInterceptor,DuplicationInterceptor duplicationInterceptor){
        this.accessInterceptor = accessInterceptor;
        this.duplicationInterceptor = duplicationInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("X-Requested-With", "Content-Type","tokenId","Signature")
                .allowCredentials(true).maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor).addPathPatterns("/**");
        registry.addInterceptor(duplicationInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }




}
