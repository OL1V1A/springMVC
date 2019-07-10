package com.lwj.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auth: lwj
 * @Date: 2019/5/28 13:00
 */
public class LogFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        beforeFilter(req, resp);
        filterChain.doFilter(req, resp);

    }

    private void beforeFilter(ServletRequest req, ServletResponse resp) {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String url = request.getRequestURI();
        String contextPath = request.getLocalAddr();
        int port = request.getLocalPort();
        String queryString = request.getQueryString();
        log.info("请求路径为:" + contextPath + ":" + port + url + "\t;请求参数为: " + queryString);
    }
}
