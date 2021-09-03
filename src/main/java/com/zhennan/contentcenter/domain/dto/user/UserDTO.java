package com.zhennan.contentcenter.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    /**
     * Id
     */

    private Integer id;

    /**
     * 微信id
     */

    private String wxId;

    /**
     * 微信昵称
     */

    private String wxNickname;

    /**
     * 角色
     */
    private String roles;

    /**
     * 头像地址
     */

    private String avatarUrl;

    /**
     * 创建时间
     */

    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 积分
     */
    private Integer bonus;


}
