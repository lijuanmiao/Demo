package cn.no7player.controller.user;

import cn.no7player.common.JsonResult;
import cn.no7player.service.IUserService;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录接口
 * Created by lijm on 2017-09-26.
 */
@RestController
@RequestMapping(value = "/manager")
@Api(value = "用户登录", description = "用户登录")
public class UserLoginController{

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public JsonResult login(String username,String password){

        JsonResult result = userService.login(username, password);
        if(!result.equals("0000")){
            return JsonResult.error(result.getResCode(),result.getResDesc());
        }
        return JsonResult.success();
    }

    /**
     * 退出登录
     * @param userName
     * @return
     */
    public JsonResult loginOut(String userName){

      return JsonResult.success();

    }
}