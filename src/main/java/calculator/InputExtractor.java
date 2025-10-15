package calculator;


import java.util.List;

public class InputExtractor {

    private CalculatorValidator validator;

    public InputExtractor(CalculatorValidator validator) {
        this.validator = validator;
    }

    public String getCustomSeparator(String input) {

        if (validator.hasCustomSeparator(input)) {
            int startPoint = CalculatorValidator.CUSTOM_SEPARATOR_END.length() + 1;
            int endPoint = input.indexOf(CalculatorValidator.CUSTOM_SEPARATOR_END);
            return input.substring(startPoint, endPoint);
        }
        return null;
    }
}
