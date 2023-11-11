package com.tiger.rbac.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Zenghu
 * @Date 2023年11月09日 20:37
 * @Description
 * @Version: 1.0
 **/
public class ExceptionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            request.setAttribute("filter.error", e);
            request.getRequestDispatcher("/error/exthrow").forward(request, response);
        }
    }
}
