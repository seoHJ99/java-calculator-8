package calculator;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        InputExtractor inputExtractor = new InputExtractor(inputValidator);
        Calculator calculator = Calculator.getInstance(inputExtractor);
        int result = calculator.addInputNums(InputView.inputWords());
        OutputView.outputResult(result);
    }
}
