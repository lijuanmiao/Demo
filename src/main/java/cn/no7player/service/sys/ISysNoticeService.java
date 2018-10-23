package cn.no7player.service.sys;

import cn.no7player.model.sys.TNotice;
import cn.no7player.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by lijm on 2018-05-16.
 */
public interface ISysNoticeService extends IBaseService {

     List<TNotice> getNoticeAll(Integer currPage,Integer pageSize,Map<String, Object> params);

}
