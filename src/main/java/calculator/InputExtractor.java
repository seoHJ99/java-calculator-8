package calculator;


import java.util.ArrayList;
import java.util.List;

public class InputExtractor {

    private InputValidator validator;

    public InputExtractor(InputValidator validator) {
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

        String regex = InputValidator.BASIC_SEPARATOR_1 + "|" + InputValidator.BASIC_SEPARATOR_2;

        if (!validator.hasCustomSeparator(input)) {
            return input.split(regex);
        }

        regex += "|" + getCustomSeparator(input);
        int endPoint = input.indexOf(InputValidator.CUSTOM_SEPARATOR_END) + InputValidator.CUSTOM_SEPARATOR_END.length();

        return input.substring(endPoint).split(regex);
    }

    private String getCustomSeparator(String input) {

        if (!validator.hasCustomSeparator(input)) {
            return null;
        }

        int startPoint = InputValidator.CUSTOM_SEPARATOR_START.length();
        int endPoint = input.indexOf(InputValidator.CUSTOM_SEPARATOR_END);
        String customSeparator = input.substring(startPoint, endPoint);

        if(!validator.validateCustomSeparator(customSeparator))
            return null;

        return customSeparator;
    }
}
