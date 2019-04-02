package com.tistory.ykyh.tddhomework;

public class Money {

    private int value;
    private MoneyType moneyType;


    public Money(int value, MoneyType moneyType) {
        this.moneyType = moneyType;
        this.value = value;
    }

    int getValue() {
        return value;
    }

    public MoneyType getMoneyType() {
        return moneyType;
    }

//    public Money plus(Money money1, Money money2,  MoneyType returnMoneyType) {
////        return MoneyFactory.createMoney(plusValue(money, value), getMoneyType());
//
//        MoneyUtil moneyUtil = new MoneyUtil();
//        int value = moneyUtil.change(money1, returnMoneyType) + moneyUtil.change(money2, returnMoneyType);
//
//        return MoneyFactory.createMoney(value, returnMoneyType);
//    }
//
//    public boolean isSame(Money money1, Money money2) {
//        if (isSameMoneyType(money1, money2)) {
//            return money1.getValue() == money2.getValue();
//        } else {
//            return money1.getValue() == new MoneyUtil().change(money2, money1.getMoneyType());
//        }
//    }
//
//    private boolean isSameMoneyType(Money money, Money money2) {
//        return money.getMoneyType() == money2.getMoneyType();
//    }
}
