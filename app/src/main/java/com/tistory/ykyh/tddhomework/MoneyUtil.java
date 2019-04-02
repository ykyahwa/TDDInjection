package com.tistory.ykyh.tddhomework;

public class MoneyUtil {

    private final float DOLLAR_TO_KRW = 1000;
    private final float KRW_TO_DOLLAR = 0.001f;

    public int change(Money from, MoneyType to) {
        if (from.getMoneyType() == to) return from.getValue();


        if (isDollarToKrw(from.getMoneyType(), to)) {
            return (int) (from.getValue()* DOLLAR_TO_KRW);
        } else if (isKrwToDollar(from.getMoneyType(), to)) {
            return (int) (from.getValue() * KRW_TO_DOLLAR);
        }
        throw new IllegalArgumentException("wrong argument form  = " + from.toString() + ", to = " + to.toString());
    }

    private boolean isKrwToDollar(MoneyType from, MoneyType to) {
        return from == MoneyType.KRW && to == MoneyType.DOLLAR;
    }

    private boolean isDollarToKrw(MoneyType from, MoneyType to) {
        return from == MoneyType.DOLLAR && to == MoneyType.KRW;
    }

    public Money plus(Money money1, Money money2,  MoneyType returnMoneyType) {
//        return MoneyFactory.createMoney(plusValue(money, value), getMoneyType());

        MoneyUtil moneyUtil = new MoneyUtil();
        int value = moneyUtil.change(money1, returnMoneyType) + moneyUtil.change(money2, returnMoneyType);

        return MoneyFactory.createMoney(value, returnMoneyType);
    }

    public boolean isSame(Money money1, Money money2) {
        if (isSameMoneyType(money1, money2)) {
            return money1.getValue() == money2.getValue();
        } else {
            return money1.getValue() == new MoneyUtil().change(money2, money1.getMoneyType());
        }
    }

    private boolean isSameMoneyType(Money money, Money money2) {
        return money.getMoneyType() == money2.getMoneyType();
    }

////    @Override
//    public Dallar change(Krw krw) {
//        return new DallarImpl(moneyType, krw.getKrw() / EXCHANGE_RATE);
//    }
//
////    @Override
//    public Krw change(Dallar dallar) {
//        return new KrwImpl(moneyType, dallar.getDallar() * EXCHANGE_RATE);
//    }
}
