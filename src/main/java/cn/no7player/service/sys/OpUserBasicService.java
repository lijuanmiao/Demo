package cn.no7player.service.sys;

import cn.no7player.mapper.TOpUserBasicMapper;
import cn.no7player.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**管理员相关接口
 * Created by lijm on 2017-12-12.
 */

@Service
public class OpUserBasicService extends BaseService implements IOpUserBasicService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    protected @Value("${global.pageSize}") Integer pageSizeDefault;

    @Autowired
    private TOpUserBasicMapper basicMapper;


    @Autowired
    void setOpUserBasicMapper(TOpUserBasicMapper opUserBasicMapper) {
        this.basicMapper = opUserBasicMapper;
        this.baseMapper = basicMapper;
    }
}