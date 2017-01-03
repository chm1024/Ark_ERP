package com.micolor.common.entities;

import java.io.Serializable;

/**
 * Created by Evangoe on 27/04/16.
 */
public class ShiroUser implements Serializable{
    private Long id;
    private String loginName;

    public ShiroUser(Long id, String loginName) {
        this.id = id;
        this.loginName = loginName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
