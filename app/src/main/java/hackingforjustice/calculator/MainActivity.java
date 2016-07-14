package hackingforjustice.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final int ADD = 1;
    private final int SUB = 2;
    private final int MUL = 3;
    private final int DIV = 4;

    private ArrayList<Double> values = new ArrayList<>();
    private ArrayList<Integer> operations = new ArrayList<>();

    private EditText textbox;
    private TextView inputView;
    private TextView error;

    public void clear() {
        textbox.setText("");
        error.setText("");
    }

    private void clearInput() {
        inputView.setText("");
    }

    private double getValue() {
        if (textbox.getText().toString().matches("")) {
            return 0.0;
        }
        return Double.parseDouble(textbox.getText().toString());
    }

    private void setText(double value) {
        textbox.setText("" + value);
    }

    private boolean checkVal() {
        //System.out.println("abdc"+textbox.getText().toString()+"123");
        if (textbox.getText().toString().equals("") || textbox.getText().toString().equals(".")) {
            return false;
        } else {
            return true;
        }
    }

    private void updateInput() {
        String input = "";
        for (int i = 0; i < operations.size(); i++) {
            input += values.get(i) + " " + getOp(operations.get(i)) + " ";
        }
        if (values.size() > operations.size()) {
            input += values.get(values.size() - 1) + " = ";
        }
        inputView.setText(input);
    }

    private String getOp(int op) {
        switch(op) {
            case ADD:
                return "+";
            case SUB:
                return "-";
            case MUL:
                return "*";
            case DIV:
                return "/";
            default:
                return "missingno";
        }
    }

//    private void printArrs() {
//        for (int i = 0; i < operations.size(); i++) {
//            System.out.println("OP " + i + " " + operations.get(i));
//        }
//        for (int i = 0; i < values.size(); i++) {
//            System.out.println("VALS " + i + " " + values.get(i));
//        }
//    }

    private double compute() {
        while(values.size() > 1) {
            for (int i = 0; i < operations.size(); i++) {
                if (operations.get(i) == MUL || operations.get(i) == DIV) {
                    if (operations.get(i) == MUL) {
                        values.set(i, values.get(i) * values.get(i + 1));
                    } else {
                        if (values.get(i + 1) == 0.0) {
                            operations.clear();
                            values.clear();
                            error.setText("Cannot divide by zero");
                            return 0.0;
                        } else {
                            values.set(i, values.get(i) / values.get(i + 1));
                        }
                    }
                    values.remove(i + 1);
                    operations.remove(i);
                    i--;
                }
            }
            for (int i = 0; i < operations.size(); i++) {
                if (operations.get(i) == ADD) {
                    values.set(i, values.get(i) + values.get(i + 1));
                } else {
                    values.set(i, values.get(i) - values.get(i + 1));
                }
                values.remove(i + 1);
                operations.remove(i);
                i--;
            }
        }
        if (values.size() > 0) {
            return values.get(0);
        } else {
            return 0.0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textbox = (EditText) findViewById(R.id.outputTextbox);
        inputView = (TextView) findViewById(R.id.inputView);
        error = (TextView) findViewById(R.id.errorBox);
    }

    public void onAdd(View view) {
        if (checkVal()) {
            values.add(getValue());
            operations.add(ADD);
        } else {
            operations.set(operations.size() - 1, ADD);
        }
        clear();
        updateInput();
    }

    public void onSub(View view) {
        if (checkVal()) {
            values.add(getValue());
            operations.add(SUB);
        } else {
            operations.set(operations.size() - 1, SUB);
        }
        clear();
        updateInput();
    }

    public void onMul(View view) {
        if (checkVal()) {
            values.add(getValue());
            operations.add(MUL);
        } else {
            operations.set(operations.size() - 1, MUL);
        }
        clear();
        updateInput();
    }

    public void onDiv(View view) {
        if (checkVal()) {
            values.add(getValue());
            operations.add(DIV);
        } else {
            operations.set(operations.size() - 1, DIV);
        }
        clear();
        updateInput();
    }

    public void onNeg(View view) {
        if (checkVal()) {
            setText(getValue() * -1.0);
        }
    }

    public void onClr(View view) {
        values.clear();
        operations.clear();
        clear();
        clearInput();
    }

    public void onEql(View view) {
        if (checkVal()) {
            values.add(getValue());
        } else {
            if (operations.size() > 0) {
                operations.remove(operations.size() - 1);
            }
        }
        updateInput();
        setText(compute());
        values = new ArrayList<>();
    }
}
