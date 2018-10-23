package cn.no7player.model.sys;

import java.io.Serializable;

/**
 * Created by lijm on 2018-04-24.
 */
public class TSysUserRole implements Serializable{

   Integer id;
   Integer opId;
   Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
