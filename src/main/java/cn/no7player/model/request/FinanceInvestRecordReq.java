package cn.no7player.model.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lijm on 2018-03-02.
 */
public class FinanceInvestRecordReq implements Serializable {

    private String userName;
    private BigDecimal amount;
    private BigDecimal earnings;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getEarnings() {
        return earnings;
    }

    public void setEarnings(BigDecimal earnings) {
        this.earnings = earnings;
    }
}
