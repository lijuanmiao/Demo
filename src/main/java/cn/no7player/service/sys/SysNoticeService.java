package cn.no7player.service.sys;

import cn.no7player.mapper.TNoticeMapper;
import cn.no7player.model.sys.TNotice;
import cn.no7player.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * Created by lijm on 2018-05-16.
 */
@Service
public class SysNoticeService extends BaseService implements ISysNoticeService{

    @Autowired
    private TNoticeMapper noticeMapper;

    @Autowired
    void setNoticeMapper(TNoticeMapper sysNoticeMapper) {
        this.noticeMapper = sysNoticeMapper;
        this.baseMapper = noticeMapper;
    }


    @Override
    public List<TNotice> getNoticeAll(Integer currPage, Integer pageSize, Map<String, Object> params){


        List<TNotice> tList = noticeMapper.selectListByParams(params,0,10000,"NID");

        //从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
        //到第几条数据结束
        int lastIndex = currPage * pageSize;
        if(tList.size()<pageSize){
            if(firstIndex<0){
                firstIndex=0;
            }
            return tList.subList(firstIndex,tList.size());
        }else{
            return tList.subList(firstIndex, lastIndex);
        }
    }
}
