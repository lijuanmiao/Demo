package cn.no7player.model.sys;

import cn.no7player.model.common.StateBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Created by lijm on 2018-04-11.
 */
public class TSysMenu implements Serializable{

    private Integer id;

    private String menuCode;

    private String upMenuCode;

    private String channelCode;

    @JsonProperty("text")
    private String menuName;

    private String menuDesc;

    private String permission;

    private String menuUrl;

    private Byte isActive;

    static final long serialVersionUID = 1L;

    private StateBean state = new StateBean();

    private String parent = "#";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getUpMenuCode() {
        return upMenuCode;
    }

    public void setUpMenuCode(String upMenuCode) {
        this.upMenuCode = upMenuCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public StateBean getState() {
        return state;
    }

    public void setState(StateBean state) {
        this.state = state;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
