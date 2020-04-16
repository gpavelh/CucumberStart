package CucumberTest.definitions;

import io.cucumber.java.ru.Допустим;

public class Add {
    int firstNum, secondNum;

    @Допустим("берём первое число {int}")
    public void берём_первое_число(Integer int1) {
        firstNum = int1;
    }

    @Допустим("и складываем со вторым числом {int}")
    public void и_складываем_со_вторым_числом(Integer int1) {
        secondNum = int1;
        System.out.println(firstNum + secondNum);
    }
}
