package cn.no7player.common;

import cn.no7player.toolbox.PropertiesValue;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * Created by lijm on 2017-09-19.
 */
public class JsonResult implements Serializable {


    @ApiModelProperty(value = "返回代码", required = true)
    private String resCode;

    @ApiModelProperty(value = "返回代码描述")
    private String resDesc;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty("返回数据")
    private  Object data;


    public JsonResult(String resCode, String resDesc, Object data) {
        this.resCode = resCode;
        this.resDesc = resDesc;
        this.version = PropertiesValue.getString("version");
        this.data = data;
    }

    public static JsonResult success() {
        return new JsonResult("0000", "操作成功", "");
    }

    public static JsonResult success(Object obj) {
        return new JsonResult("0000", "操作成功", obj);
    }

    public static JsonResult error(String resCode,String errorMessage) {
        return new JsonResult(resCode, errorMessage,"");
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
