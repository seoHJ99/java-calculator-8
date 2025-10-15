package calculator;


public class InputExtractor {

    private CalculatorValidator validator;

    public InputExtractor(CalculatorValidator validator){
        this.validator = validator;
    }

    public String getCustomSeparator(String input){
        if(validator.hasCustomSeparator(input)){
            int endPoint = input.indexOf("\\n");
            return input.substring(2,endPoint);
        }
        return null;
    }
}
