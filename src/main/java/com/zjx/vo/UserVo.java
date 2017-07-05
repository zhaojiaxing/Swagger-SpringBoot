package com.zjx.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zjx on 2017/7/5.
 */
@ApiModel(value = "用户信息")
public class UserVo {
    @ApiModelProperty(value = "用户id", required = true)
    private long userId;
    @ApiModelProperty(value = "昵称", required = true)
    private long userName;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserName() {
        return userName;
    }

    public void setUserName(long userName) {
        this.userName = userName;
    }
}
