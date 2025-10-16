package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = Calculator.getInstance();
        int result = calculator.addInputNums(InputView.inputWords());
        OutputView.outputResult(result);
    }
}
