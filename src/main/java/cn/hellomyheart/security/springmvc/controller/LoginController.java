package cn.hellomyheart.security.springmvc.controller;

import cn.hellomyheart.security.springmvc.model.AuthenticationRequest;
import cn.hellomyheart.security.springmvc.model.UserDto;
import cn.hellomyheart.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "login",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String Login(AuthenticationRequest authenticationRequest){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        return userDto.getUsername()+ "登录成功";
    }
}
