package cn.daxalfred.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        Object obj1 = httpServletRequest.getSession().getAttribute("student");
        Object obj2 = httpServletRequest.getSession().getAttribute("admin");
        if(obj!=null||obj2!=null){
            return true;
        }else if (requestURI.endsWith("login")||requestURI.endsWith("checkCode")||requestURI.endsWith("register")||requestURI.contains("userCentre")) {
            return true;
            }else {
                httpServletResponse.sendRedirect("/login.jsp");
                return false;
            }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
