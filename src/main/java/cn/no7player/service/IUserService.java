package cn.no7player.service;

import cn.no7player.common.JsonResult;
import cn.no7player.model.User;
import java.util.List;
import java.util.Map;

/**
 * Created by lijm on 2017-09-21.
 */
public interface IUserService {

    User getUserInfo(Map<String, Object> params);

    void  insertUser(User user);

    JsonResult delUser(Integer id);

    JsonResult login(String userId,String password);

    void addUserBatchBasic(List<User> obj) throws Exception;

    List<User> findUserAll(Map<String,Object> params);
}
