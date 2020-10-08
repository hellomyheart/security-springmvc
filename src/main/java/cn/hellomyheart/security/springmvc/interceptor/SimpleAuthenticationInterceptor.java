package cn.hellomyheart.security.springmvc.interceptor;

import cn.hellomyheart.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description 权限拦截器
 * @className: SimpleAuthenticationInterceptor
 * @package: cn.hellomyheart.security.springmvc.interceptor
 * @author: Stephen Shen
 * @date: 2020/10/8 上午10:18
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //校验用户请求的url是否在用户请求的url内
        //取出用户的身份信息
        response.setCharacterEncoding("gb2312");
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null) {
            //没有认证提示登录
            writerContent(response,"请登录");
            return false;
        }
        UserDto user = (UserDto) object;

        //请求的URI
        String requestURI =request.getRequestURI();
        if (user.getAuthorities().contains("p1") && requestURI.contains("/r/r1")){
            return true;
        }
        if (user.getAuthorities().contains("p2") && requestURI.contains("/r/r2")){
            return true;
        }
        writerContent(response,"权限不足，拒绝访问");
        return false;
    }

    private void writerContent(HttpServletResponse response, String msg) throws IOException {
        PrintWriter writer =response.getWriter();
        writer.print(msg);
        writer.close();
    }
}
