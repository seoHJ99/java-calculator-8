package calculator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputExtractor {

    private static InputExtractor inputExtractor;

    private InputValidator validator;

    private InputExtractor() {
        this.validator = InputValidator.getInstance();
    }

    public static InputExtractor getInstance(){
        if(inputExtractor == null) inputExtractor = new InputExtractor();
        return inputExtractor;
    }

    public List<Integer> getNumbers(String input) {
        List<Integer> numList = new ArrayList<>();

        String separator = getCustomSeparator(input);
        input = replaceCustomSeparator(input);

        if(validator.isEmpty(input)){
            return numList;
        }

        String[] elements = splitBySeparators(input, separator);

        for (String element : elements) {
            validator.validateInputNumber(element);
            numList.add(Integer.parseInt(element));
        }

        return numList;
    }

    private String replaceCustomSeparator(String input){
        if(!validator.hasCustomSeparator(input))
            return input;

        int endPoint = input.indexOf(InputValidator.CUSTOM_SEPARATOR_END) + InputValidator.CUSTOM_SEPARATOR_END.length();
        return input.substring(endPoint);
    }

    private String[] splitBySeparators(String input, String separator) {

        String regex = InputValidator.BASIC_SEPARATOR_1 + "|" + InputValidator.BASIC_SEPARATOR_2;

        if (separator == null) {
            return input.split(regex);
        }

        regex += "|" + separator;

        return input.split(regex);
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
