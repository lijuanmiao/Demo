package cn.no7player.controller.sys;

import cn.no7player.common.ApiResultHelper;
import cn.no7player.model.request.ContractReq;
import cn.no7player.service.sys.IElectContractService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lijm on 2018-03-09.
 */

@RestController
@RequestMapping("/manager/contract")
@Api(value = "生成pdf文档", description = "生成pdf文档")
public class EdocumentApi {

    @Autowired
    private IElectContractService electContractService;


    @RequestMapping(value="/p2pIntermediary", method= RequestMethod.POST)
    ApiResultHelper p2pIntermediary(@RequestBody @Validated ContractReq contractReq)throws Exception{

        electContractService.produceContract(contractReq,null);
        return ApiResultHelper.success();
    }
}