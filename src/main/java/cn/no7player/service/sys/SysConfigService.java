package cn.no7player.service.sys;

import cn.no7player.mapper.TSysConfigMapper;
import cn.no7player.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lijm on 2018-04-03.
 */
@Service
public class SysConfigService extends BaseService implements ISysConfigService {

    @Autowired
    private TSysConfigMapper sysConfigMapper;

    @Autowired
    void setSysConfigMapper(TSysConfigMapper configMapper) {
        this.sysConfigMapper = configMapper;
        this.baseMapper = sysConfigMapper;
    }

    @Override
    public void delConfig(String configCode){

        sysConfigMapper.deleteByParams(configCode);
    }
}
