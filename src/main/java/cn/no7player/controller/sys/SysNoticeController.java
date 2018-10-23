package cn.no7player.controller.sys;

import cn.no7player.common.ApiResultHelper;
import cn.no7player.model.sys.TNotice;
import cn.no7player.service.sys.ISysNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijm on 2018-05-15.
 */
@RestController
@RequestMapping(value = "/manager/notice")
@Api(value = "公告配置", description = "公告配置")
public class SysNoticeController{

    @Autowired
    private ISysNoticeService sysNoticeService;

    @RequestMapping(value="/setNotice", method= RequestMethod.POST)
    @ApiOperation(value = "新增公告", notes = "新增公告")
    ApiResultHelper addNotice(@RequestBody @Validated TNotice notice)throws Exception{
        sysNoticeService.addBasic(notice);
        return ApiResultHelper.success();
    }

    @RequestMapping(value = "/getNoticeList",method = RequestMethod.GET)
    @ApiOperation(value= "公告列表",notes = "公告列表")
    ApiResultHelper getNoticeList(@RequestParam(value = "title",required = false)String title,
                                  @ApiParam(required = true, name = "iPage", value = "首页",defaultValue = "1")@RequestParam("iPage") Integer iPage,
                                  @ApiParam(required = true, name = "pageSize", value = "页大小",defaultValue = "20")
                                  @RequestParam("pageSize")Integer pageSize){

        Map<String, Object> params = new HashMap<String, Object>();
       // RollPage nLit = sysNoticeService.findListPageByParams(params, Order.asc("nId"),iPage,pageSize);
        List<TNotice> nList = sysNoticeService.getNoticeAll(iPage,pageSize,params);
        params.clear();
        params.put("nList",nList);
        params.put("resultCount",nList.size());
        params.put("currPage",iPage);
        params.put("pageSize",pageSize);
        return ApiResultHelper.success(params);
    }


    @RequestMapping(value = "updateNotice",method = RequestMethod.POST)
    @ApiOperation(value = "修改公告",notes = "修改公告")
    ApiResultHelper updateNotice(@ApiParam(required = true, name = "id", value = "编号")
                              @RequestParam("id")Integer id,
                              @RequestParam(value = "title",required = false) String title,
                              @RequestParam(value = "context",required = false) String context)throws Exception{

        TNotice notice = (TNotice) sysNoticeService.findObjByKey(id);
        if(notice!=null){

            TNotice noticeUpdate = new TNotice();
            noticeUpdate.setnId(notice.getnId());
            noticeUpdate.setTitle(title);
            noticeUpdate.setContext(context);
            sysNoticeService.modifyBasic(noticeUpdate);

            return ApiResultHelper.success();
        }
        return ApiResultHelper.error("1001","不存在");
    }

    @RequestMapping(value = "delNotice",method = RequestMethod.POST)
    @ApiOperation(value = "删除公告",notes = "删除公告")
    ApiResultHelper delNotice(@ApiParam(required = true, name = "id", value = "编号")
                              @RequestParam("id")Integer id)throws Exception{
        sysNoticeService.delBasic(id);
        return ApiResultHelper.success();
    }
}
