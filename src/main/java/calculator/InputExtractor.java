package calculator;


import java.util.ArrayList;
import java.util.List;

public class InputExtractor {

    private CalculatorValidator validator;

    public InputExtractor(CalculatorValidator validator) {
        this.validator = validator;
    }

    public List<Integer> getNumbers(String input) {
        List<Integer> numList = new ArrayList<>();
        String[] elements = splitBySeparators(input);

        for (String element : elements) {
            validator.validateInputNumber(element);
            numList.add(Integer.parseInt(element));
        }

        return numList;
    }

    private String[] splitBySeparators(String input) {

        String regex = CalculatorValidator.BASIC_SEPARATOR_1 + "|" + CalculatorValidator.BASIC_SEPARATOR_2;

        if (!validator.hasCustomSeparator(input)) {
            return input.split(regex);
        }

        regex += "|" + getCustomSeparator(input);
        int endPoint = input.indexOf(CalculatorValidator.CUSTOM_SEPARATOR_END) + CalculatorValidator.CUSTOM_SEPARATOR_END.length();
        
        return input.substring(endPoint).split(regex);
    }

    private String getCustomSeparator(String input) {

        if (validator.hasCustomSeparator(input)) {
            int startPoint = CalculatorValidator.CUSTOM_SEPARATOR_START.length();
            int endPoint = input.indexOf(CalculatorValidator.CUSTOM_SEPARATOR_END);
            return input.substring(startPoint, endPoint);
        }
        return null;
    }
}
