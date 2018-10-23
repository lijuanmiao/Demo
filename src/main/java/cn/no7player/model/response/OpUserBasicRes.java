package cn.no7player.model.response;

import java.io.Serializable;

/**
 * Created by lijm on 2018-01-25.
 */
public class OpUserBasicRes implements Serializable{

    private String loginName;
    private String realName;
    private String mobile;
    private String email;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
