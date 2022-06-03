package ru.netology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import java.time.Duration;

public class CardDeliveryTest {

    @Test
    void shouldRegisterByAccount() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");

        $("[placeholder=\"Город\"]").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").setValue("06.06.2022");
        $("[data-test-id=\"name\"] input").setValue("Иванов Иван");
        $("[data-test-id=\"phone\"] input").setValue("+79991234567");
        $("[data-test-id=\"agreement\"]").click();
        $x("//*[text()=\"Забронировать\"]").click();
        $(byText("Встреча успешно забронирована на")).should(visible,Duration.ofSeconds(15));
    }
}
