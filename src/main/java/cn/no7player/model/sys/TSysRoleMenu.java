package cn.no7player.model.sys;

import java.io.Serializable;

/**
 * Created by lijm on 2018-04-24.
 */
public class TSysRoleMenu implements Serializable{

    Integer id;
    Integer roleId;
    Integer menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}