package cn.no7player.mapper;

import cn.no7player.model.sys.TSysConfig;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lijm on 2018-04-03.
 */
public interface TSysConfigMapper extends IBaseMapper<TSysConfig> {

    int deleteByParams(@Param("configCode") String configCode);
}
