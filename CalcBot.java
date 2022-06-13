
public class CalcBot {
    double firstNumber = 0;
    double secondNumber = 0;

    String firstSign = "";

    double resultSmallCalculate = 0;
    String resultString = "";

    public void initiateNumber(String number, String signString){
        if (firstNumber == 0){
            firstNumber = Double.parseDouble(number);
            firstSign = signString;
        }

        else {
            secondNumber = Double.parseDouble(number);
        }

    }

    public void clearAll(){
        firstNumber = 0;
        secondNumber = 0;
        firstSign = "";
    }

    public double smallCalculate(){
        if (firstSign == "+"){
            resultSmallCalculate = firstNumber + secondNumber;
        }
        else if (firstSign == "-"){
            resultSmallCalculate = firstNumber - secondNumber;
        }
        else if (firstSign == "x"){
            resultSmallCalculate = firstNumber * secondNumber;
        }
        else if (firstSign == "/"){
            resultSmallCalculate = firstNumber/secondNumber;
        }
        resultString = Double.toString(resultSmallCalculate);
        return resultSmallCalculate;
    }

    public String NumberFormatter (){
        int shortenedIndex = resultString.length() - 2;
        double tempRes = resultSmallCalculate - (int)resultSmallCalculate;
        if (tempRes<0.00001){resultString = resultString.substring(0,shortenedIndex);}
        return resultString;
    }

}
