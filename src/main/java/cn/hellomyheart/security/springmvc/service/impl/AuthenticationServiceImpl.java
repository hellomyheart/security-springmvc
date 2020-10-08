package cn.hellomyheart.security.springmvc.service.impl;

import cn.hellomyheart.security.springmvc.model.AuthenticationRequest;
import cn.hellomyheart.security.springmvc.model.UserDto;
import cn.hellomyheart.security.springmvc.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description 认证接口实现类
 * @className: AuthenticationServiceImpl
 * @package: cn.hellomyheart.security.springmvc.service.impl
 * @author: Stephen Shen
 * @date: 2020/10/7 下午5:23
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        //校验参数是否为空
        if (authenticationRequest == null
                || StringUtils.isEmpty(authenticationRequest.getUsername())
                || StringUtils.isEmpty(authenticationRequest.getPassword())) {
            throw new RuntimeException("账号或密码为空");
        }
        UserDto user = getUserDtos(authenticationRequest.getUsername());
        //判断是否为空
        if (user == null) {
            throw new RuntimeException("查询不到该用户");
        }
        if (!authenticationRequest.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("账号或密码错误");
        }
        //认证通过，返回身份信息
        return user;
    }

    //模拟用户查询，根据账号
    public UserDto getUserDtos(String username) {
        return userMap.get(username);
    }

    //用户信息
    private Map<String, UserDto> userMap = new HashMap<>();

    {
        Set<String> authorities1 = new HashSet<>();
        //p1是访问r/r1的权限
        authorities1.add("p1");
        Set<String> authorities2 = new HashSet<>();
        //p2是访问r/r2的权限
        authorities2.add("p2");
        userMap.put("zhangsan", new UserDto("1010", "zhangsan", "123", "张三", "133443",authorities1));
        userMap.put("lisi", new UserDto("1011", "lisi", "456", "李四", "144556",authorities2));
    }

    ;
}
