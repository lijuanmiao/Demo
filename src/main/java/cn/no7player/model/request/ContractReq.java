package cn.no7player.model.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijm on 2018-03-02.
 */
public class ContractReq implements Serializable{

    private String lenderName;
    private String lenderIdCard;
    private String lenderPhone;
    private String lenderAdress;
    private String registerPhone;
    private BigDecimal lendMoney;
    private BigDecimal lendApr;
    private String lendTerm;
    private String repayType;
    private String loanUsage;
    private BigDecimal serviceRate;
    private String year;
    private String month;
    private String day;
    private String contractNo;
    private String templateName;

    List<FinanceInvestRecordReq> list = new ArrayList<>();

    public List<FinanceInvestRecordReq> getList() {
        return list;
    }

    public void setList(List<FinanceInvestRecordReq> list) {
        this.list = list;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getLenderName() {
        return lenderName;
    }

    public void setLenderName(String lenderName) {
        this.lenderName = lenderName;
    }

    public String getLenderIdCard() {
        return lenderIdCard;
    }

    public void setLenderIdCard(String lenderIdCard) {
        this.lenderIdCard = lenderIdCard;
    }

    public String getLenderPhone() {
        return lenderPhone;
    }

    public void setLenderPhone(String lenderPhone) {
        this.lenderPhone = lenderPhone;
    }

    public String getLenderAdress() {
        return lenderAdress;
    }

    public void setLenderAdress(String lenderAdress) {
        this.lenderAdress = lenderAdress;
    }

    public String getRegisterPhone() {
        return registerPhone;
    }

    public void setRegisterPhone(String registerPhone) {
        this.registerPhone = registerPhone;
    }

    public BigDecimal getLendMoney() {
        return lendMoney;
    }

    public void setLendMoney(BigDecimal lendMoney) {
        this.lendMoney = lendMoney;
    }

    public BigDecimal getLendApr() {
        return lendApr;
    }

    public void setLendApr(BigDecimal lendApr) {
        this.lendApr = lendApr;
    }

    public String getLendTerm() {
        return lendTerm;
    }

    public void setLendTerm(String lendTerm) {
        this.lendTerm = lendTerm;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getLoanUsage() {
        return loanUsage;
    }

    public void setLoanUsage(String loanUsage) {
        this.loanUsage = loanUsage;
    }

    public BigDecimal getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(BigDecimal serviceRate) {
        this.serviceRate = serviceRate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
}
