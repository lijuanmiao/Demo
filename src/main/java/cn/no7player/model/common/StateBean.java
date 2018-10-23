package cn.no7player.model.common;

import java.io.Serializable;

/**
 * Created by lijm on 2018-04-11.
 */
public class StateBean implements Serializable{

    private Boolean opened = true;
    private Boolean disabled  = false;
    private Boolean selected  = false;

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
