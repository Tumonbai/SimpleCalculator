package com.lawlett.simlecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultField;
    Double firstValues, twoValues, result;
    String operation;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultField = findViewById(R.id.result_field);
        if (savedInstanceState != null) {
            text = savedInstanceState.getString("key");
            resultField.setText(text);
        }
        Log.e("TAG", "onCreate:+= " + text);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                resultField.setText(resultField.getText() +"1");
                break;
            case R.id.two:
                resultField.setText(resultField.getText() +"2");
                break;
            case R.id.clear:
                resultField.setText("");
                break;
            case R.id.three:
                resultField.setText(resultField.getText() +"3");
                break;
            case R.id.four:
                resultField.setText(resultField.getText() +"4");
                break;
            case R.id.five:
                resultField.setText(resultField.getText().toString() + "5");
                break;
            case R.id.six:
                resultField.setText(resultField.getText() +"6");
                break;
            case R.id.seven:
                resultField.setText(resultField.getText() +"7");
                break;
            case R.id.eight:
                resultField.setText(resultField.getText() +"8");
                break;
            case R.id.nine:
                resultField.setText(resultField.getText() +"9");
                break;
            case R.id.zero:
                resultField.setText(resultField.getText() +"0");
                break;
            case R.id.plus:
                resultField.setText(resultField.getText() +"+");
                break;
        }

    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                operation = "+";
                firstValues = Double.valueOf(resultField.getText().toString());
                resultField.setText(firstValues + "+");
                break;
            case R.id.division:
                operation = "/";
                firstValues = Double.valueOf(resultField.getText().toString());
                resultField.setText(firstValues + "/");
                break;

            case R.id.maltiply:
                operation = "*";
                firstValues = Double.valueOf(resultField.getText().toString());
                resultField.setText(firstValues + "*");
                break;

            case R.id.mines:
                operation = "-";
                firstValues = Double.valueOf(resultField.getText().toString());
                resultField.setText(firstValues + "-");
                break;


            case R.id.equal:
                if (operation != null) {
                    String two = resultField.getText().toString()
                            .replace(firstValues + operation + "", "");
                    twoValues = Double.valueOf(two);
                    switch (operation) {
                        case "+":
                            plusOp();
                            break;
                        case "/":
                            divisionOp();
                            break;
                        case "-":
                            minesOp();
                            break;
                        case "*":
                            maltiplyOp();
                            break;

                    }
                }
        }
    }

    private void maltiplyOp() {
        result = firstValues * twoValues;
        resultField.setText(result.toString());
    }

    private void minesOp() {
        result = firstValues - twoValues;
        resultField.setText(result.toString());
    }

    public void plusOp() {
        result = firstValues + twoValues;
        resultField.setText(result.toString());
    }

    public void divisionOp() {
        result = firstValues / twoValues;
        resultField.setText(result.toString());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("key", resultField.getText().toString());
        Log.e("TAG", "onSaveInstanceState: " + resultField.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resultField.setText(savedInstanceState.getString("key"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        text = resultField.getText().toString().trim();
    }
}
