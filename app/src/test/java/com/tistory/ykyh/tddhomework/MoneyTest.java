package com.tistory.ykyh.tddhomework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyTest {

    private MoneyUtil moneyUtil;
    @Before
    public void prepare() {
        moneyUtil = new MoneyUtil();
    }

    @Test
    public void equalsDallar() {
        //5dallar = 5dallar

        Money d1 = MoneyFactory.createMoney(5, MoneyType.DOLLAR);
        Money d2 = MoneyFactory.createMoney(5, MoneyType.DOLLAR);
//        Dallar d1 = new DallarImpl(5);
//        Dallar d2 = new DallarImpl(5);

        assertTrue(moneyUtil.isSame(d1, d2));
    }

    @Test
    public void plusDallar() {
        //5dallar + 5dallar = 10dallar
//        Dallar d1 = new DallarImpl(moneyType, 5);
//        Dallar d2 = new DallarImpl(moneyType, 5);

        Money d1 = MoneyFactory.createMoney(5, MoneyType.DOLLAR);
        Money d2 = MoneyFactory.createMoney(5, MoneyType.DOLLAR);

        Money d3 = moneyUtil.plus(d1, d2, MoneyType.DOLLAR);
        assertEquals(d3.getValue(), 10);
    }

    @Test
    public void equalsKrw() {
        //5000krw = 5000krw
//        Krw k1 = new KrwImpl(moneyType, 5000);
//        Krw k2 = new KrwImpl(moneyType, 5000);

        Money m1 = MoneyFactory.createMoney(5000, MoneyType.KRW);
        Money m2 = MoneyFactory.createMoney(5000, MoneyType.KRW);

        assertTrue(moneyUtil.isSame(m1, m2));
    }

    @Test
    public void plusKrw() {
        //5000krw + 5000krw = 10000krw

//        Krw k1 = new KrwImpl(moneyType, 5000);
//        Krw k2 = new KrwImpl(moneyType, 5000);

        Money m1 = MoneyFactory.createMoney(5000, MoneyType.KRW);
        Money m2 = MoneyFactory.createMoney(5000, MoneyType.KRW);

        Money m3 = moneyUtil.plus(m1, m2, MoneyType.KRW);
        assertEquals(m3.getValue(), 10000);
    }

    @Test
    public void change() {
        MoneyUtil moneyUtil = new MoneyUtil();
        int changeMoney = moneyUtil.change(MoneyFactory.createMoney(5, MoneyType.DOLLAR), MoneyType.KRW);

        assertEquals(changeMoney, 5000);
    }

    @Test
    public void changePlusToDallar() {
        //5000krw = 5dallar
//        Krw k1 = new KrwImpl(moneyType, 5000);
//        Dallar d1 = new DallarImpl(moneyType, 5);
//        MoneyUtil m = new MoneyUtil();
//
//        assertTrue(k1.isSame(m.change(d1)));


        Money m1 = MoneyFactory.createMoney(5000, MoneyType.KRW);
        Money m2 = MoneyFactory.createMoney(5, MoneyType.DOLLAR);

        assertTrue(moneyUtil.isSame(m1, m2));
    }

    @Test
    public void pluskrwDallar() {
        //5000krw +5dallar = 10dallar
//        Krw k1 = new KrwImpl(moneyType, 5000);
//        Dallar d1 = new DallarImpl(moneyType, 5);
//
//        MoneyUtil m = new MoneyUtil();
//
//        Dallar d2 = m.change(k1.plus(m.change(d1)));
//        assertEquals(d2.getDallar(), 10);


        Money m1 = MoneyFactory.createMoney(5000, MoneyType.KRW);
        Money m2 = MoneyFactory.createMoney(5, MoneyType.DOLLAR);

        assertEquals(moneyUtil.plus(m1, m2, MoneyType.DOLLAR).getValue(), 10);

    }


}
