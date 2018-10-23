package cn.no7player.controller.user;

import cn.no7player.common.ApiResultHelper;
import cn.no7player.model.sys.TSysRoleBasic;
import cn.no7player.service.sys.ISysRoleService;
import cn.no7player.toolbox.DateUtil;
import cn.no7player.toolbox.constant.CommonTypeConstant;
import com.wordnik.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lijm on 2018-04-02.
 */
@RestController
@RequestMapping(value = "/manager/api/role")
@Api(value = "角色信息-后台", description = "角色信息-后台")
public class SysRoleController {

    @Autowired
    private ISysRoleService sysRoleService;


    @RequestMapping(value="/addRole", method= RequestMethod.POST)
    @ApiOperation(value = "新增角色", notes = "新增角色")
    ApiResultHelper addRole(@RequestBody @Validated TSysRoleBasic roleBasic)throws Exception{

        if (roleBasic.getIsDefaultAllocate() == Byte.parseByte(CommonTypeConstant.YesOrNo.No.toString())){
            roleBasic.setIsDefaultAllocate(Byte.parseByte(CommonTypeConstant.YesOrNo.No.toString()));
        }else{
            roleBasic.setIsDefaultAllocate(Byte.parseByte(CommonTypeConstant.YesOrNo.Yes.toString()));
        }
        roleBasic.setIsActive(Byte.parseByte(CommonTypeConstant.IsActive.True.getValue()));
        roleBasic.setCreateTime(DateUtil.getTime().getTime());
        sysRoleService.addBasic(roleBasic);
        return ApiResultHelper.success();
    }

    @RequestMapping(value = "delRole",method = RequestMethod.POST)
    @ApiOperation(value = "删除角色",notes = "删除角色")
    ApiResultHelper delRole(@ApiParam(required = true, name = "id", value = "编号",defaultValue = "1")
                            @RequestParam("id")Integer id)throws Exception{
        sysRoleService.delBasic(id);
        return ApiResultHelper.success();
    }

    @RequestMapping(value = "getAllMenu",method = RequestMethod.GET)
    @ApiOperation(value = "获取角色菜单" ,notes = "获取角色菜单")
    ApiResultHelper getAllRole(){

        return ApiResultHelper.success();
    }

}