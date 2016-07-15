package hackingforjustice.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final int ADD = 1;
    public final int SUB = 2;
    public final int MUL = 3;
    public final int DIV = 4;

    public ArrayList<Double> values = new ArrayList<>();
    public ArrayList<Integer> operations = new ArrayList<>();

    public EditText textbox;
    public TextView inputView;
    public TextView error;

    public void clear() {
        textbox.setText("");
        error.setText("");
    }

    public void clearInput() {
        inputView.setText("");
    }

    public double getValue() {
        if (textbox.getText().toString().matches("")) {
            return 0.0;
        }
        return Double.parseDouble(textbox.getText().toString());
    }

    public void setText(double value) {
        textbox.setText("" + value);
    }

    public boolean checkValue() {
        return !(textbox.getText().toString().equals("") || textbox.getText().toString().equals("."));
    }

    public void updateInput() {
        String input = "";
        for (int i = 0; i < operations.size(); i++) {
            input += values.get(i) + " " + getOp(operations.get(i)) + " ";
        }
        if (values.size() > operations.size()) {
            input += values.get(values.size() - 1) + " = ";
        }
        inputView.setText(input);
    }

    public String getOp(int op) {
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

    public double compute() {
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

        ImageView valor = (ImageView) findViewById(R.id.valor);
        assert valor != null;
        valor.setImageResource(R.drawable.valor_logo);
        textbox = (EditText) findViewById(R.id.outputTextbox);
        inputView = (TextView) findViewById(R.id.inputView);
        error = (TextView) findViewById(R.id.errorBox);
    }

    public void onAdd(View view) {
        if (checkValue()) {
            values.add(getValue());
            operations.add(ADD);
            clear();
        } else {
            if (operations.size() > 0) {
                operations.set(operations.size() - 1, ADD);
            }
        }
        updateInput();
    }

    public void onSub(View view) {
        if (checkValue()) {
            values.add(getValue());
            operations.add(SUB);
            clear();
        } else {
            if (operations.size() > 0) {
                operations.set(operations.size() - 1, SUB);
            }
        }
        updateInput();
    }

    public void onMul(View view) {
        if (checkValue()) {
            values.add(getValue());
            operations.add(MUL);
            clear();
        } else {
            if (operations.size() > 0) {
                operations.set(operations.size() - 1, MUL);
            }
        }
        updateInput();
    }

    public void onDiv(View view) {
        if (checkValue()) {
            values.add(getValue());
            operations.add(DIV);
            clear();
        } else {
            if (operations.size() > 0) {
                operations.set(operations.size() - 1, DIV);
            }
        }
        updateInput();
    }

    public void onNeg(View view) {
        if (checkValue()) {
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
        if (checkValue()) {
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
