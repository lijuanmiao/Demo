package cn.no7player.mapper;

import cn.no7player.model.User;
import java.util.List;

/**用户基本信息
 * Created by lijm on 2017/8/27.
 */
public interface UserMapper extends IBaseMapper<User> {

    User findUserInfo(Integer id);

    //批量新增
    int insertBatch(List<User> user);

}
