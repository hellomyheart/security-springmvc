package cn.hellomyheart.security.springmvc.service;

import cn.hellomyheart.security.springmvc.model.AuthenticationRequest;
import cn.hellomyheart.security.springmvc.model.UserDto;

/**
 * @description 认证接口
 * @className: AuthenticationService
 * @package: cn.hellomyheart.security.springmvc.service
 * @author: Stephen Shen
 * @date: 2020/10/7 下午5:15
 */
public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求，账号密码
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
