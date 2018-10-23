package cn.no7player.service.sys;

import cn.no7player.model.request.ContractReq;
import cn.no7player.model.request.FinanceInvestRecordReq;
import cn.no7player.toolbox.utils.FileConvertUtil;
import cn.no7player.toolbox.utils.HideNameOrPhoneUtil;
import cn.no7player.toolbox.utils.RandomUtil;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijm on 2018-03-02.
 */
@Service
public class ElectContractService implements IElectContractService{


    @Override
    public void produceContract(ContractReq contractReq,List<FinanceInvestRecordReq> recordReqsList){

        Map<String, Object> data = new HashMap();
        data.put("lenderName", HideNameOrPhoneUtil.hideName(contractReq.getLenderName()));
        data.put("lenderAdress", contractReq.getLenderAdress() + "****");
        data.put("lenderIdCard", HideNameOrPhoneUtil.hideIdCard(contractReq.getLenderIdCard()));
        data.put("lenderPhone", HideNameOrPhoneUtil.hidePhone(contractReq.getLenderPhone()));
        data.put("registerPhone", HideNameOrPhoneUtil.hidePhone(contractReq.getRegisterPhone()));
        //data.put("lendMoney", BigDecimalUtil.currencyFormat(contractReq.getLendMoney()));
        data.put("chineseRMB", contractReq.getLendMoney()); //大写
        data.put("loanUsage", contractReq.getLoanUsage());
        data.put("lendTerm", contractReq.getLendTerm());
       // data.put("lendApr", BigDecimalUtil.percentFormat2(contractReq.getLendApr()));
        data.put("repayType", contractReq.getRepayType());
       // data.put("serviceRate", BigDecimalUtil.percentFormat2(contractReq.getServiceRate()));
        data.put("year", contractReq.getYear());
        data.put("month", contractReq.getMonth());
        data.put("day", contractReq.getDay());

        List<FinanceInvestRecordReq> dataList = new ArrayList<>();

        for(FinanceInvestRecordReq recordReq:contractReq.getList()){

            FinanceInvestRecordReq req = new FinanceInvestRecordReq();
            req.setUserName(recordReq.getUserName());
            req.setAmount(recordReq.getAmount());
            req.setEarnings(recordReq.getEarnings());

            dataList.add(req);//
        }

        data.put("dataList", dataList);
        generateContract(data,contractReq);

    }

    /**
     * 生成合同
     * @param data
     */
    public void generateContract(Map<String,Object> data,ContractReq contractReq){

        String uploadBasePath= "F://img//";
        //合同文件名称：合同号+合同类型+2位随机数
        String fileName = contractReq.getContractNo() + "-"+ RandomUtil.getNum(2);

        String templatePath = "F://img//";
        FileConvertUtil.toPDFWriteValue(templatePath+contractReq.getTemplateName(),fileName+".pdf",uploadBasePath,data);
    }
}
