package cn.no7player.service;

import cn.no7player.common.JsonResult;
import cn.no7player.mapper.UserMapper;
import cn.no7player.model.User;
import cn.no7player.toolbox.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijm on 2015/8/27.
 */
@Service
public class UserService implements  IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(Map<String, Object> params){

        User user=userMapper.selectByParams(params);
        return user;
    }

    @Override
    public  void insertUser(User user){
        userMapper.insert(user);
    }

    @Override
    public JsonResult delUser(Integer id){

        User user=userMapper.findUserInfo(id);
        if(user==null){

         return JsonResult.error("0001","用户信息不存在");
        }else{
            userMapper.deleteByPrimaryKey(id);
        }

        return JsonResult.success();
    }

    @Override
    public JsonResult login(String userId,String password){

        //验证用户是否存在
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("userId",userId);
        User user = userMapper.selectByParams(params);
        if(user==null){
            return JsonResult.error("0002","用户不存在！");
        }
        if(!PasswordHandler.getPassword(password).equals(user.getPassword())){
            return JsonResult.error("0003","密码错误,请重新再试！");
        }
        return JsonResult.success();
    }

    @Override
    @Transactional
    public void  addUserBatchBasic(List<User> obj) throws Exception{
        userMapper.insertBatch(obj);
    }


    @Override
    public List<User> findUserAll(Map<String,Object> params){

       List<User> uList = userMapper.selectListByParams(params,0,1000, null);
       return uList;

    }
}