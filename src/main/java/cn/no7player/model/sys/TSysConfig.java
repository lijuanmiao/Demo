package cn.no7player.model.sys;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * Created by lijm on 2018-04-03.
 */
public class TSysConfig implements Serializable{

    @ApiModelProperty(value = "序号")
    private Integer id;

    @ApiModelProperty(value = "参数编号")
    private String configCode;

    @ApiModelProperty(value = "参数名称")
    private String configName;

    @ApiModelProperty(value = "参数描述")
    private String configDesc;

    @ApiModelProperty(value = "业务类型(1系统；2业务配置；3费率设置)")
    private Byte busiType;

    @ApiModelProperty(value = "子业务类型(21房贷标；22充值；23提现；24渠道返佣；25信用标；26体验金；31房贷借款;32投资；33充值；34提现；35信用；11 文件上传下载；12 房贷网 ;13 活动)")
    private Byte childType;

    @ApiModelProperty(value = "参数类型(1:文本输入框 2:数字输入框)")
    private Byte configType;

    @ApiModelProperty(value = "参数值")
    private String configVlaue;

    @ApiModelProperty(value = "参数默认值")
    private String configDefaultValue;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "是否有效(1:有效 2:无效)")
    private Byte isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigDesc() {
        return configDesc;
    }

    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc;
    }

    public Byte getBusiType() {
        return busiType;
    }

    public void setBusiType(Byte busiType) {
        this.busiType = busiType;
    }

    public Byte getChildType() {
        return childType;
    }

    public void setChildType(Byte childType) {
        this.childType = childType;
    }

    public Byte getConfigType() {
        return configType;
    }

    public void setConfigType(Byte configType) {
        this.configType = configType;
    }

    public String getConfigVlaue() {
        return configVlaue;
    }

    public void setConfigVlaue(String configVlaue) {
        this.configVlaue = configVlaue;
    }

    public String getConfigDefaultValue() {
        return configDefaultValue;
    }

    public void setConfigDefaultValue(String configDefaultValue) {
        this.configDefaultValue = configDefaultValue;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}