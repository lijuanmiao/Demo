package cn.no7player.core.cache;

import cn.no7player.model.sys.TSysConfig;
import cn.no7player.service.sys.ISysConfigService;
import cn.no7player.toolbox.common.Order;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;

/**
 * Created by lijm on 2018-04-04.
 */
public class SysConfigCache {
    final static  Logger logger = LoggerFactory.getLogger(SysConfigCache.class);

    @Autowired
     private ISysConfigService sysConfigService;

    public  List<TSysConfig> getSysConfigValue()throws Exception{

        logger.info("============加载缓存数据================");
        sysConfigService = (ISysConfigService) SpringBeanHelper.getBean("sysConfigService");
        Map<String,Object> params = new HashMap<String,Object>();
        List<TSysConfig> sysConfigList = sysConfigService.findListByParams(params, Order.asc("create_time"));
        return sysConfigList;
    }
}
