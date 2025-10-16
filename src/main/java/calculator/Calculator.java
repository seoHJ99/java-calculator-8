package calculator;

import java.util.List;

public class Calculator {
    private InputExtractor inputExtractor;

    private static Calculator calculator;

    private Calculator(){
        this.inputExtractor = InputExtractor.getInstance();
    }

    public static Calculator getInstance(){
        if(calculator == null){
            calculator = new Calculator();
        }
        return calculator;
    }

    public int addInputNums(String input) {
        List<Integer> inputNums = inputExtractor.getNumbers(input);
        return inputNums.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
