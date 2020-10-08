package cn.hellomyheart.security.springmvc.model;

import lombok.Data;

/**
 * @description 用户请求参数，账号密码
 * @className: AuthenticationRequest
 * @package: cn.hellomyheart.security.springmvc.model
 * @author: Stephen Shen
 * @date: 2020/10/7 下午5:18
 */
@Data
public class AuthenticationRequest {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
