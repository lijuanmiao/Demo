package cn.no7player.controller.sys;

import cn.no7player.common.ApiResultHelper;
import cn.no7player.toolbox.utils.HttpRequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lijm on 2018-03-22.
 */
@RestController
@RequestMapping("/test")
@Api(value = "测试demo", description = "测试demo")
public class TestController {

    @RequestMapping(value="/getCity",method = RequestMethod.GET)
    ApiResultHelper testGet(@ApiParam(required = true, name = "pCode", value = "编号",defaultValue = "1")
                            @RequestParam("pCode") String pCode)throws Exception{

        String url = "http://10.52.2.203:7016/ppm/contentNew/"+pCode+"/detail";

        //String res = HttpRequestUtil.getInstance().sendHttpGet(url);
        String res = HttpRequestUtil.sendGet(url,"");
        System.out.print(res);
        return ApiResultHelper.success(res);
    }


    /*public static void main(String[] args){
        int[] arr = {2,4,1,9,12,7};
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int num :arr){
            System.out.print(num);
        }
    }*/

}
