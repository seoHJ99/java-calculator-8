package calculator;


import java.util.ArrayList;
import java.util.List;

public class InputExtractor {

    private CalculatorValidator validator;

    public InputExtractor(CalculatorValidator validator) {
        this.validator = validator;
    }


    private String[] splitBySeparators(String input) {

        String regex = CalculatorValidator.BASIC_SEPARATOR_1 + "|" + CalculatorValidator.BASIC_SEPARATOR_2;

        if (validator.hasCustomSeparator(input)) {
            return input.split(regex);
        }

        regex += "|" + getCustomSeparator(input);
        return input.split(regex);
    }

    private String getCustomSeparator(String input) {

        if (validator.hasCustomSeparator(input)) {
            int startPoint = CalculatorValidator.CUSTOM_SEPARATOR_END.length() + 1;
            int endPoint = input.indexOf(CalculatorValidator.CUSTOM_SEPARATOR_END);
            return input.substring(startPoint, endPoint);
        }
        return null;
    }
}
