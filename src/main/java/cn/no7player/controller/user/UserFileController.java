package cn.no7player.controller.user;

import cn.no7player.common.JsonResult;
import cn.no7player.exceptions.ApiException;
import cn.no7player.toolbox.DateUtil;
import cn.no7player.toolbox.PropertiesValue;
import com.wordnik.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 处理文件上传
 * Created by lijm on 2017-09-21.
 */
@Controller
@RequestMapping(value = "/manager/file")
@Api(value = "文件上传", description = "文件上传")
public class UserFileController {

    /**
     * 上传图片
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
     public JsonResult uploadFile(@RequestParam(value = "file") MultipartFile file)throws Exception{


        String subName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
        if (!(subName.equalsIgnoreCase("JPG") || subName.equalsIgnoreCase("PNG") || subName.equalsIgnoreCase("BMP"))) {
          throw new ApiException("61204", "文件格式不支持");
        }
        String sufferName = file.getOriginalFilename();
        if (file!=null) {

            //获取文件的后缀名
            String subffix = sufferName.substring(sufferName.lastIndexOf(".") + 1, sufferName.length());

            String path = PropertiesValue.getString("path");//文件暂时存放
            File targetFile = new File(path);
            if(!targetFile.isDirectory()) targetFile.mkdirs();

            //对文件名进行处理
            String fileName = DateUtil.formatDate(DateUtil.getTime(), "yyyyMMddHHmmss")+DateUtil.randomChar(3)+ "." + subffix;
            file.transferTo(new File(path + fileName));
        }
        return JsonResult.success();
    }

    /**
     * 下载文件
     * @param name
     * @param resp
     * @throws Exception
     */
    @RequestMapping(value = "/downFile",method = RequestMethod.GET)
    public void downFile( @ApiParam(required = true, name = "name", value = "名称")
                              @RequestParam("name")String name, HttpServletResponse resp)throws Exception{

        resp.setContentType("application/force-download");//设置响应类型

        String path = "F:\\"+name;
        InputStream in = new FileInputStream(path);
        name = URLEncoder.encode(name,"UTF-8");
        resp.setHeader("Content-disposition", "attachment;  filename=\"" + name + "\"");
        resp.setContentLength(in.available());

        //开始copy
        OutputStream out = resp.getOutputStream();
        byte[] b = new byte[1024];
        int len = 0 ;
        while((len = in.read(b))!=-1){
            out.write(b,0,len);
        }
        out.flush();
        out.close();
        in.close();
    }
}

