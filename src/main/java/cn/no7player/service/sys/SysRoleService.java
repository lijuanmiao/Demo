package cn.no7player.service.sys;

import cn.no7player.mapper.TSysRoleBasicMapper;
import cn.no7player.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lijm on 2018-04-02.
 */
@Service
public class SysRoleService extends BaseService implements ISysRoleService{

    @Autowired
    private TSysRoleBasicMapper basicMapper;


    @Autowired
    void setOpUserBasicMapper(TSysRoleBasicMapper sysRoleBasicMapper) {
        this.basicMapper = sysRoleBasicMapper;
        this.baseMapper = basicMapper;
    }

}
