package cn.hellomyheart.security.springmvc.controller;

import cn.hellomyheart.security.springmvc.model.AuthenticationRequest;
import cn.hellomyheart.security.springmvc.model.UserDto;
import cn.hellomyheart.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @description 登录控制器
 * @className: LoginController
 * @package: cn.hellomyheart.security.springmvc.controller
 * @author: Stephen Shen
 * @date: 2020/10/7 下午5:56
 */
@RestController
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String Login(AuthenticationRequest authenticationRequest, HttpSession httpSession){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        //存入session
        httpSession.setAttribute(UserDto.SESSION_USER_KEY,userDto);
        return userDto.getUsername()+ "登录成功";
    }

    @GetMapping(value = "/logout",produces = {"text/plain;charset=utf-8"})
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "退出成功";
    }

    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession httpSession){
        String fullname=null;

        Object object = httpSession.getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null){
            fullname =null;
        }else {
            UserDto userDto =(UserDto) object;
            fullname = userDto.getFullname();
        }
        return fullname+"访问资源r1";
    }

    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=utf-8"})
    public String r2(HttpSession httpSession){
        String fullname=null;

        Object object = httpSession.getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null){
            fullname =null;
        }else {
            UserDto userDto =(UserDto) object;
            fullname = userDto.getFullname();
        }
        return fullname+"访问资源r2";
    }

}
