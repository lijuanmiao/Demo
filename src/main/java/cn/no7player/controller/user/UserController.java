package cn.no7player.controller.user;

import cn.no7player.common.ApiResultHelper;
import cn.no7player.common.JsonResult;
import cn.no7player.model.User;
import cn.no7player.service.IUserService;
import cn.no7player.service.sys.ISysRoleService;
import cn.no7player.toolbox.DateUtil;
import cn.no7player.toolbox.PasswordHandler;
import cn.no7player.toolbox.PropertiesValue;
import cn.no7player.toolbox.common.RollPage;
import cn.no7player.toolbox.constant.CommonTypeConstant;
import cn.no7player.toolbox.excel.ExcelUtil;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijm on 2017/09/21.
 */
@RestController
@RequestMapping(value = "/manager/api/user")
@Api(value = "用户基本信息", description = "用户基本信息")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ISysRoleService sysRoleService;

    @RequestMapping(value = "/getRolesList",method = RequestMethod.GET)
    @ApiOperation(value = "角色列表",notes = "角色列表")
    ApiResultHelper getRoleList(@RequestParam(value = "roleName",required = false)String roleName,
                                @ApiParam(required = true, name = "iPage", value = "首页",defaultValue = "1")@RequestParam("iPage") Integer iPage,
                                @ApiParam(required = true, name = "pageSize", value = "页大小",defaultValue = "20")
                                @RequestParam("pageSize")Integer pageSize){

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleName",roleName);
        params.put("isActive",Integer.parseInt(CommonTypeConstant.IsActive.True.getValue()));
        RollPage oList = sysRoleService.findListPageByParams(params, null,iPage,pageSize);
        return ApiResultHelper.success(oList);
    }
    /**
     * 获取用户基本信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value = "用户信息查询", notes = "用户信息查询")
    ApiResultHelper getUserInfo(@RequestParam(value = "userId",required = true) String userId) {

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userId",userId);
        User user = userService.getUserInfo(params);

        return  ApiResultHelper.success(user);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    public ApiResultHelper insertUser(@RequestParam("userId") String userId, @RequestParam("age") Integer age, @RequestParam("name") String name, @RequestParam("password") String password) {

        User user = new User();
        user.setUserId(userId);
        user.setAge(age);
        user.setName(name);
        user.setPassword(PasswordHandler.getPassword(password));
        userService.insertUser(user);
        return ApiResultHelper.success();
    }

    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    public JsonResult delUser(@ApiParam(required = true, name = "id", value = "编号",defaultValue = "1")@RequestParam("id") Integer id) {

        JsonResult  result = userService.delUser(id);
        if(!result.equals("0000")){
            //===输出异常提示
            return JsonResult.error(result.getResCode(),result.getResDesc());
        }
        return JsonResult.success();
    }

    /**
     * excel导入
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/reImport",method = RequestMethod.POST)
    @ApiOperation(value = "批量新增用户信息", notes = "批量新增用户信息")
    public JsonResult reImport(@RequestPart(value = "file", required = false) MultipartFile file)throws Exception{


        String fileName = file.getOriginalFilename();//获取文件名称
        if(file!=null){

            String subffix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
            if("XLS".equalsIgnoreCase(subffix) || "XLSX".equalsIgnoreCase(subffix)){

                String path = PropertiesValue.getString("path");
                File targetFile = new File(path,fileName);
                file.transferTo(targetFile);//临时存放文件

                String[][] excel = ExcelUtil.readExcel(targetFile,2);

                List<User> succList = new ArrayList<User>();
                int rowLength = excel.length;
                if(rowLength>0){
                    for(int i=0;i<rowLength;i++){

                        User user = new User();
                        String userId = excel[i][0]==null?"":excel[i][0];
                        String name = excel[i][1] == null?"":excel[i][1];
                        String age = excel[i][2] == null?"":excel[i][2];

                        user.setUserId(userId);
                        user.setName(name);
                        user.setAge(Integer.parseInt(age));
                        user.setPassword(PasswordHandler.getPassword("888888"));
                        succList.add(user);
                    }
                }
                userService.addUserBatchBasic(succList);
            }
        }
        return JsonResult.success();
    }

    /**
     * excel导出
     * @param response
     */
    @RequestMapping(value = "/reExport", method = RequestMethod.GET)
    @ApiOperation(value = "导出用户信息", notes = "导出用户信息")
    public void reExcept(HttpServletResponse response)throws Exception{

        String destFilePath = URLEncoder.encode(DateUtil.formatDate(DateUtil.getTime(),"yyyyMMdd")+"user.xlsx","utf-8");
        response.reset();
        response.setContentType("application/msexcel");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment; filename=\""+destFilePath+"\"");

        InputStream inputStream = null;
        OutputStream out = null;
        String templateName =  "templates/user.xlsx";
        inputStream = this.getClass().getClassLoader().getResourceAsStream(templateName);

        Map<String,Object> params = new HashMap<String,Object>();
        List<User> userList = userService.findUserAll(params);
        out = response.getOutputStream();

        int maxLen = 3;//excel的sheet最大存多少数据
        ExcelUtil.generateExcelByTemplate(out, inputStream, userList, "userList", maxLen);
    }
}
