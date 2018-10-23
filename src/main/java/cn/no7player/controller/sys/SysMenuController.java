package cn.no7player.controller.sys;

import cn.no7player.common.ApiResultHelper;
import cn.no7player.service.sys.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by lijm on 2018-08-13.
 */
@RestController
@RequestMapping(value = "/manager/menu")
@Api(value = "菜单配置", description = "菜单配置")
public class SysMenuController {

    @Autowired
    private ISysMenuService sysMenuService;

    @RequestMapping(value = "/getMenuList",method = RequestMethod.GET)
    @ApiOperation(value= "菜单列表",notes = "菜单列表")
    ApiResultHelper getNoticeList()throws Exception{

        List list = sysMenuService.getAllMenu("1");
        return ApiResultHelper.success(list);
    }

}
