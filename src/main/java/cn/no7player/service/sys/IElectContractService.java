package cn.no7player.service.sys;

import cn.no7player.model.request.ContractReq;
import cn.no7player.model.request.FinanceInvestRecordReq;

import java.util.List;

/**电子合同测试
 * Created by lijm on 2018-03-02.
 */
public interface IElectContractService{


   void produceContract(ContractReq contractReq, List<FinanceInvestRecordReq> recordReqsList);//数据可以动态写入
}
