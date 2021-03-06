package cn.hellomyheart.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @description 用户身份信息DTO
 * @className: UserDto
 * @package: cn.hellomyheart.security.springmvc.model
 * @author: Stephen Shen
 * @date: 2020/10/7 下午5:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    public static final String SESSION_USER_KEY = "_user";
    /**
     * 用户身份信息
     */
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
    /**
     * 用户权限
     */
    private Set<String> authorities;
}
