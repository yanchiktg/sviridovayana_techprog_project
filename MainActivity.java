package com.example.yo_calc;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String OldNumber;
    String Operator = "";
    Boolean Cheker = true;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.Result);
    }

    public void ClickNumber(View view) {
        if(Cheker)
            editText.setText("");
        Cheker = false;
        String number = editText.getText().toString();
        switch (view.getId()){
            case R.id.bu1:
                if(ZeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"1" ;
                break;

            case R.id.bu2:
                if(ZeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"2" ;
                break;

            case R.id.bu3:
                if(ZeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"3" ;
                break;

            case R.id.bu4:
                if(ZeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"4" ;
                break;

            case R.id.bu5:
                if(ZeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"5" ;
                break;

            case R.id.bu6:
                if(ZeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"6" ;
                break;

            case R.id.bu7:
                if(ZeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"7" ;
                break;

            case R.id.bu8:
                if(ZeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"8" ;
                break;

            case R.id.bu9:
                if(ZeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number+"9" ;
                break;

            case R.id.bu0:
                if(ZeroIsFirst(number) && number.length() == 1) {
                    number = "0";
                }
                else {
                    number = number + "0";
                }
                break;

            case R.id.buDot:
                if (DotIsPresent(number)) {
                    if (number.length() == 0) {
                        number = number + "0.";
                    }
                    else{
                        number = number + ".";
                    }
                }
                break;

            case R.id.buPlusMinus:
                if(NumberIsZero(number)) {
                    if (MinusIsPresent(number))
                        number = "-" + number;
                    else
                        number = number.substring(1);
                }
                else{
                    number = "0";
                    Cheker = true;
                }
                break;
        }
        editText.setText(number);
    }

    private boolean ZeroIsFirst(String number){
        if(number.equals("")){
            return true;
        }

        if(number.charAt(0) == '0'){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean NumberIsZero(String number){
        if(number.equals("0") || number.equals("")){
            return false;
        }
        else{
            return true;
        }
    }

    public void Operation(View view) {
        Cheker = true;
        OldNumber = editText.getText().toString();
        switch (view.getId()){
            case R.id.buMultiply: Operator = "*" ;break;
            case R.id.buDivide: Operator = "/" ;break;
            case R.id.buPlus: Operator = "+" ;break;
            case R.id.buMinus: Operator = "-" ;break;
        }
    }

    public void ClickEqual(View view) {
        String Newnumber = editText.getText().toString();
        Double Result = 0.0;

        switch (Operator){
            case "-": Result = Double.parseDouble(OldNumber) - Double.parseDouble(Newnumber) ;break;
            case "+": Result = Double.parseDouble(OldNumber) + Double.parseDouble(Newnumber) ;break;
            case "*": Result = Double.parseDouble(OldNumber) * Double.parseDouble(Newnumber) ;break;
            case "/": Result = Double.parseDouble(OldNumber) / Double.parseDouble(Newnumber) ;break;
        }

        DecimalFormat df = new DecimalFormat("#.#####");
        editText.setText(df.format(Result)+"");
        Operator = "";
    }

    public void CClick(View view) {
        editText.setText("");
        editText.setText("0");
        Cheker = true;
    }

    public boolean DotIsPresent(String number){
        if(number.indexOf(".") == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean MinusIsPresent(String number){
        if(number.indexOf("-") == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public void ClickPercent(View view) {
        if(Operator == ""){
            String number = editText.getText().toString();
            double temp = Double.parseDouble(number)/100;
            editText.setText(temp+"");
        }
        else{
            String Newnumber = editText.getText().toString();
            Double Result = 0.0;
            switch (Operator){
                case "-": Result = Double.parseDouble(OldNumber) - (Double.parseDouble(Newnumber)*Double.parseDouble(OldNumber)/100);break;
                case "+": Result = Double.parseDouble(OldNumber) + (Double.parseDouble(Newnumber)*Double.parseDouble(OldNumber)/100) ;break;
                case "*": Result = Double.parseDouble(OldNumber) * (Double.parseDouble(Newnumber)/100) ;break;
                case "/": Result = Double.parseDouble(OldNumber) / (Double.parseDouble(Newnumber)/100) ;break;
            }
            editText.setText(Result+"");
            Operator = "";
        }

    }
}