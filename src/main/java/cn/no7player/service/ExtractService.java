package cn.no7player.service;

import cn.no7player.model.LinkTypeData;
import cn.no7player.model.Rule;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 核心查询类
 * Created by lijm on 2017-10-26.
 */
public class ExtractService {

    public static List<LinkTypeData> extract(Rule rule){

        List<LinkTypeData> datas = new ArrayList<LinkTypeData>();
        LinkTypeData data = null;
        try{
            String url = rule.getUrl();
            String[] params = rule.getParams();
            String[] values = rule.getValues();
            String resultTagName = rule.getResultTagName();
            int type = rule.getType();
            int requestType = rule.getRequestMoethod();

            Connection conn =null;// Jsou


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return datas;
    }
}
