package calculator;

public class CalculatorValidator {
    private static final String SEPARATOR_START = "//";
    private static final String SEPARATOR_END = "\\n";

    public boolean hasCustomSeparator(String input){
        if(input.startsWith(SEPARATOR_START) && input.indexOf(SEPARATOR_END) >0){
            return  true;
        }
        return false;
    }
}
