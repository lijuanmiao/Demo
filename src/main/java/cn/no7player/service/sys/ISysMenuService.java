package cn.no7player.service.sys;

import cn.no7player.model.sys.TSysMenu;
import cn.no7player.service.IBaseService;

import java.util.List;

/**
 * Created by lijm on 2018-04-25.
 */
public interface ISysMenuService extends IBaseService{

    List<TSysMenu> getAllMenu(String channelCode);
}
