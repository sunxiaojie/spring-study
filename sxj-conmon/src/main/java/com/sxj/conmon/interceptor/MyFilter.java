package com.sxj.conmon.interceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义Filter
 *      1 开启注解[@ServletComponentScan]
 *      2 Filter加载是在tomcat中
 *
 * @author: Sxj
 * @date: 19-8-1
 **/
@WebFilter(filterName = "myFilter",urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("===========================my filter===============================");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
