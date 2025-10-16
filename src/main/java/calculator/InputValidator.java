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

        // 구분자에 숫자를 포함시키면 실제 숫자와 구분자의 경계가 모호해짐
        if(hasNumber(separator))
            throw new IllegalArgumentException("구분자에는 숫자가 포함될 수 없습니다.");

        return true;
    }

    public boolean validateInputNumber(String element){
        if(!isNumber(element))
            throw new IllegalArgumentException("더하려는 값이 숫자가 아닙니다.");

        if(Integer.parseInt(element) <0)
            throw new IllegalArgumentException("양수만 입력받을 수 있습니다.");

        return true;
    }

    private boolean isNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }

    private boolean hasNumber(String input){
        return input.matches(".*\\d.*");
    }

    private boolean isBasicSeparator(String separator){
        if(separator.equals(BASIC_SEPARATOR_1) || separator.equals(BASIC_SEPARATOR_2)){
            return true;
        }
        return false;
    }


}
