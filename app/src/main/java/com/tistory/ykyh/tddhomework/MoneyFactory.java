package com.tistory.ykyh.tddhomework;

public class MoneyFactory {
    public static Money createMoney(int value, MoneyType moneyType) {
        return new Money(value,moneyType);
    }
}
