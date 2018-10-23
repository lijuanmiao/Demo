package cn.no7player.controller.sys;

import cn.no7player.common.ApiResultHelper;
import cn.no7player.core.cache.SysConfigCache;
import cn.no7player.model.sys.TSysConfig;
import cn.no7player.service.sys.ISysConfigService;
import cn.no7player.toolbox.DateUtil;
import cn.no7player.toolbox.constant.CommonTypeConstant;
import com.wordnik.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijm on 2018-04-03.
 */
@RestController
@RequestMapping("/manager/config")
@Api(value = "参数配置", description = "参数配置")
public class SysConfigController {

    @Autowired
    private ISysConfigService sysConfigService;

    @RequestMapping(value="/add", method= RequestMethod.POST)
    @ApiOperation(value = "新增参数配置", notes = "新增参数配置")
    ApiResultHelper addConfig(@RequestBody @Validated TSysConfig sysConfig)throws Exception{

        sysConfig.setIsActive(Byte.parseByte(CommonTypeConstant.IsActive.True.getValue()));
        sysConfig.setCreateTime(DateUtil.getTime().getTime());
        sysConfigService.addBasic(sysConfig);
        return ApiResultHelper.success();
    }

    @RequestMapping(value="/addConfig", method= RequestMethod.POST)
    @ApiOperation(value = "新增参数配置", notes = "新增参数配置")
    ApiResultHelper add(String configCode, String configName,String configDesc)throws Exception{

        TSysConfig sysConfig = new TSysConfig();
        sysConfig.setConfigCode(configCode);
        sysConfig.setConfigName(configName);
        sysConfig.setConfigDesc(configDesc);
        sysConfig.setConfigVlaue(configCode);
        sysConfig.setIsActive(Byte.parseByte(CommonTypeConstant.IsActive.True.getValue()));
        sysConfig.setCreateTime(DateUtil.getTime().getTime());
        sysConfigService.addBasic(sysConfig);
        return ApiResultHelper.success();
    }

    @RequestMapping(value="getSysConfig",method = RequestMethod.GET)
    @ApiOperation(value = "参数列表",notes = "参数列表")
    ApiResultHelper configList()throws Exception{

        SysConfigCache sysConfigCache = new SysConfigCache();
        List<TSysConfig> tSysConfigList = sysConfigCache.getSysConfigValue();
        return ApiResultHelper.success(tSysConfigList);
    }

    @RequestMapping(value = "findSysConfig",method = RequestMethod.GET)
    @ApiOperation(value = "参数查询",notes = "参数查询")
    ApiResultHelper getConfig(String configCode)throws Exception{

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("configCode",configCode);
        Object obj = sysConfigService.findObj(params);
        TSysConfig config = (TSysConfig) obj;
        return ApiResultHelper.success(config);
    }

    @RequestMapping(value = "delConfig",method = RequestMethod.POST)
    @ApiOperation(value = "删除参数",notes = "删除参数")
    ApiResultHelper delConfig(String configCode){

        sysConfigService.delConfig(configCode);
        return ApiResultHelper.success();
    }
}
