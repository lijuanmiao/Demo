package cn.no7player.controller.sys;

import cn.no7player.common.ApiResultHelper;
import cn.no7player.model.sys.TOpUserBasic;
import cn.no7player.service.sys.IOpUserBasicService;
import cn.no7player.toolbox.DateUtil;
import cn.no7player.toolbox.PasswordHandler;
import cn.no7player.toolbox.common.RollPage;
import cn.no7player.toolbox.constant.CommonTypeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
/**
 * Created by lijm on 2017-10-27.
 */
@RestController
@RequestMapping("/manager/sys/user")
@Api(value = "用户基本信息-后台", description = "用户基本信息-后台")
public class OpUserBasicController{

    @Autowired
    private IOpUserBasicService opUserBasicService;

    /**
     * 管理员列表
     * @return
     */
    @RequestMapping(value = "/getOpUserList",method = RequestMethod.GET)
    ApiResultHelper getUserList(@RequestParam(value = "loginName",required = false)String loginName,
                                @RequestParam(required = false,value = "mobile")String mobile,
                                @ApiParam(required = true, name = "iPage", value = "首页",defaultValue = "1")@RequestParam("iPage") Integer iPage,
                                @ApiParam(required = true, name = "pageSize", value = "页大小",defaultValue = "20")
                                @RequestParam("pageSize")Integer pageSize){

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("loginName",loginName);
        params.put("mobile",mobile);
        params.put("isActive",Integer.parseInt(CommonTypeConstant.IsActive.True.getValue()));
        RollPage oList = opUserBasicService.findListPageByParams(params, null,iPage,pageSize);
        return ApiResultHelper.success(oList);
    }

    /**
     * 新增管理员
     * @param opBasic
     * @return
     */
    @RequestMapping(value="/addOpUser", method= RequestMethod.POST)
    ApiResultHelper addOpUserBasic(@RequestBody @Validated TOpUserBasic opBasic)throws Exception{

        opBasic.setCreateOpId(0);
        opBasic.setCreateOpName("root");
        opBasic.setCreateTime(DateUtil.currentTimeLong());
        opBasic.setPassword(PasswordHandler.getPassword(opBasic.getPassword()));
        opBasic.setIsActive(Integer.parseInt(CommonTypeConstant.IsActive.True.getValue()));
        opUserBasicService.addBasic(opBasic);
        return ApiResultHelper.success();
    }

    /**
     * 更新管理员
     * @param opBasic
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/updateOpUser",method = RequestMethod.POST)
    ApiResultHelper updateOpUserBasic(@RequestBody @Validated TOpUserBasic opBasic)throws Exception{

        opBasic.setUpTime(DateUtil.currentTimeLong());
        opUserBasicService.modifyBasic(opBasic);
        return ApiResultHelper.success();
    }

    /**
     * 删除管理员
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/delOpUser",method = RequestMethod.POST)
    ApiResultHelper delOpUserBasic(@ApiParam(required = true, name = "id", value = "编号",defaultValue = "1")
                                   @RequestParam("id") Integer id)throws Exception{

        opUserBasicService.delBasic(id);
        return ApiResultHelper.success();
    }
}