package com.ya;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest (String name, boolean expected){
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Test data: {0}")
    public static Object[][] PrintName() {
        return new Object[][]{
                {"Timothy Chalamet", true}, // кол-во символов внутри диапазона граничных знаечений
                {"T C", true}, //граничное значение 3
                {"Timothy Chalametich", true}, //граничное значение 19
                {"Timothy Chalametitich", false}, //граничное значение > 19
                {"Ti", false}, //граничное значение < 3
                {" TimothyChalame", false},
                {"TimothyChalame ", false},
                {"TimothyChalamet", false},
                {"Timothy  Chalamet", false}, // 2 пробела
                {"Timothy Chal amet", false},
                {"Timothy_Chalamet", false},
                {"", false},
                {null, false}, //  Получилось! Ахонь, спаисбо)). Не в тот иф запихивала проверку на null
        };
    }

    @Test
    @DisplayName("Name is valid")
    public void checkNameToEmbossTest(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

}
