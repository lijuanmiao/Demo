package cn.no7player.controller.sys;

import cn.no7player.toolbox.utils.ImageCodeUtils;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lijm on 2018-03-08.
 */
@RestController
@RequestMapping("/manager/image")
@Api(value = "生成图形验证码", description = "生成图形验证码")
public class ImageCodeApi {


    @RequestMapping(value = "/generVerifyCode",method = RequestMethod.GET)
    void imageVerifyCode(HttpServletResponse response)throws Exception {

        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        String code = ImageCodeUtils.generateVerifyCode(4);
        int w = 200,h = 80;
        ImageCodeUtils.outputImage(w, h, response.getOutputStream(), code);
    }
}