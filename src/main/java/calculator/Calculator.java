package calculator;

import java.util.List;

public class Calculator {
    private InputExtractor inputExtractor;

    private static Calculator calculator;

    private Calculator(InputExtractor inputExtractor){
        this.inputExtractor = inputExtractor;
    }

    public static Calculator getInstance(InputExtractor inputExtractor){
        if(calculator == null){
            calculator = new Calculator(inputExtractor);
        }
        calculator.inputExtractor = inputExtractor;
        return calculator;
    }

    public int addInputNums(String input) {
        List<Integer> inputNums = inputExtractor.getNumbers(input);
        return inputNums.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
