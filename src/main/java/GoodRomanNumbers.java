enum ROMAN_NUMBER {
    M(1000),
    CM(900),
    D(500),
    CD(400),
    C(100),
    XC(90),
    L(50),
    XL(40),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    int arabic;

    ROMAN_NUMBER(int arabic){
        this.arabic = arabic;
    }

    public static ROMAN_NUMBER[] getRomanNumbers(){
        return ROMAN_NUMBER.values();
    }
}


public class GoodRomanNumbers {
    ROMAN_NUMBER[] romanNumbers = ROMAN_NUMBER.getRomanNumbers();

    public String parse(String inputNumber) {
        if (isArabic(inputNumber)) return romanNumberOf(inputNumber);
        else if (isRoman(inputNumber)) return arabicNumberOf(inputNumber);
        else return "Wrong input!";
    }

    private String romanNumberOf(String inputNumber) {
        int arabicNumber = Integer.parseInt(inputNumber);

        StringBuilder resultingRomanNumber = new StringBuilder();
        for(ROMAN_NUMBER romanNumber : romanNumbers){
            while (arabicNumber >= romanNumber.arabic){
                resultingRomanNumber.append(romanNumber);
                arabicNumber -= romanNumber.arabic;
            }
        }

        return resultingRomanNumber.toString();
    }

    private String arabicNumberOf(String inputNumber) {
        int resultingArabicNumber = 0;
        for(ROMAN_NUMBER romanNumber : romanNumbers){
            while(inputNumber.length() > 0 && inputNumber.startsWith(romanNumber.toString())){
                resultingArabicNumber += romanNumber.arabic;
                inputNumber = inputNumber.substring(romanNumber.toString().length());
            }
        }

        return String.valueOf(resultingArabicNumber);
    }

    private boolean isArabic(String number) {
        return number.matches("[0-9]+") && !number.matches("0+");
    }

    private boolean isRoman(String number) {
        return number.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        GoodRomanNumbers romanNumbers = new GoodRomanNumbers();
        System.out.println(romanNumbers.parse(args[0]));
    }
}
