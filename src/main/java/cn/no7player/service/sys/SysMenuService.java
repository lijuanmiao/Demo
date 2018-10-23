package cn.no7player.service.sys;


import cn.no7player.mapper.TSysMenuMapper;
import cn.no7player.model.sys.TSysMenu;
import cn.no7player.service.BaseService;
import cn.no7player.toolbox.constant.CommonTypeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijm on 2018-04-25.
 */
@Service
public class SysMenuService extends BaseService implements ISysMenuService{


    @Autowired
    private TSysMenuMapper sysMenuMapper;


    @Override
    @Cacheable
    public List<TSysMenu> getAllMenu(String channelCode){

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("isActive", CommonTypeConstant.IsActive.True.getValue().toString());
        params.put("channelCode",channelCode);
        return sysMenuMapper.selectListByParams(params,null,null,null);
    }

}
