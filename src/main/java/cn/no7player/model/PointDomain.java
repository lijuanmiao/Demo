package cn.no7player.model;

/**积分计算对象
 * Created by lijm on 2017-10-20.
 */
public class PointDomain {

    private String userName;//用户名
    private boolean birthDay;//是否当日生日
    private long point; //增加积分数目
    private int buyNums;//当月退货次数
    private double buyMoney;//当月购买总金额
    private int billThisMonth;//当月信用卡还款次数

    /**
     * 防止重复提交
     * @param userName
     * @param type
     */
    public  void recordPointLog(String userName,String type){

        System.out.print("增加对"+userName+"的类型为"+type+"类型的记录");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isBirthDay() {
        return birthDay;
    }

    public void setBirthDay(boolean birthDay) {
        this.birthDay = birthDay;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public int getBuyNums() {
        return buyNums;
    }

    public void setBuyNums(int buyNums) {
        this.buyNums = buyNums;
    }

    public double getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(double buyMoney) {
        this.buyMoney = buyMoney;
    }

    public int getBillThisMonth() {
        return billThisMonth;
    }

    public void setBillThisMonth(int billThisMonth) {
        this.billThisMonth = billThisMonth;
    }

}
