package calculator;

public class CalculatorValidator {
    public static final String CUSTOM_SEPARATOR_START = "//";
    public static final String CUSTOM_SEPARATOR_END = "\\n";
    public static final String BASIC_SEPARATOR_1 =",";
    public static final String BASIC_SEPARATOR_2 =":";

    public boolean hasCustomSeparator(String input){
        if(input.startsWith(CUSTOM_SEPARATOR_START) && input.indexOf(CUSTOM_SEPARATOR_END) >0){
            return  true;
        }
        return false;
    }

    public boolean validateCustomSeparator(String separator){
        if(isBasicSeparator(separator))
            throw new IllegalArgumentException("신규 커스텀 구분자를 추가해 주세요");

        if(isNumber(separator))
            throw new IllegalArgumentException("구분자는 숫자일수 없습니다.");

        return true;
    }

    public boolean isNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }

    private boolean isBasicSeparator(String separator){
        if(separator.equals(BASIC_SEPARATOR_1) || separator.equals(BASIC_SEPARATOR_2)){
            return true;
        }
        return false;
    }


}
