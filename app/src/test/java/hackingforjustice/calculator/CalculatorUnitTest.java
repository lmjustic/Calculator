package hackingforjustice.calculator;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CalculatorUnitTest {
    MainActivity main = new MainActivity();


    @Test
    public void addition_isCorrect() throws Exception {
        main.operations.add(main.ADD);
        main.values.add(7.0);
        main.values.add(-9.0);

        assertEquals(-2, main.compute(), 0.01);

        main.operations.clear();
        main.values.clear();
    }

    @Test
    public void subtraction_isCorrect() throws Exception {
        main.operations.add(main.SUB);
        main.values.add(-9.0);
        main.values.add(-7.0);

        assertEquals(-2, main.compute(), 0.001);

        main.operations.clear();
        main.values.clear();
    }

    @Test
    public void multiplication_isCorrect() throws Exception {
        main.operations.add(main.MUL);
        main.values.add(-9.0);
        main.values.add(7.0);

        assertEquals(-63, main.compute(), 0.001);

        main.operations.clear();
        main.values.clear();
    }

    @Test
    public void division_isCorrect() throws Exception {
        main.operations.add(main.DIV);
        main.values.add(9.0);
        main.values.add(-3.0);

        assertEquals(-3, main.compute(), 0.001);

        main.operations.clear();
        main.values.clear();
    }

    @Test
    public void orderOfOperations_isCorrect() throws Exception {
        main.operations.add(main.ADD);
        main.operations.add(main.DIV);
        main.operations.add(main.MUL);
        main.operations.add(main.SUB);
        main.values.add(1.0);
        main.values.add(4.0);
        main.values.add(2.0);
        main.values.add(3.0);
        main.values.add(5.0);

        assertEquals(2.0, main.compute(), 0.001);

        main.operations.clear();
        main.values.clear();
    }

//    @Test
//    public void divideByZero_isCorrect() throws Exception {
//        main.operations.add(main.DIV);
//        main.values.add(5.0);
//        main.values.add(0.0);
//        main.compute();
//    }
//
//    @Test
//    public void checkValue_isCorrect() throws Exception {
//        main.textbox.setText(".");
//        assert(!main.checkValue());
//
//        main.textbox.setText("");
//        assert(!main.checkValue());
//
//        main.textbox.setText("2.2");
//        assert(main.checkValue());
//
//        main.textbox.setText("2.");
//        assert(main.checkValue());
//
//        main.textbox.setText(".2");
//        assert(main.checkValue());
//
//        main.textbox.setText("-.2");
//        assert(main.checkValue());
//    }
//
//    @Test
//    public void updateInput_isCorrect() throws Exception {
//        main.operations.add(main.ADD);
//        main.values.add(2.0);
//        main.values.add(-2.01);
//        main.updateInput();
//
//        assertEquals("2.0 + -2.01 = ", main.inputView.getText().toString());
//
//        main.operations.add(main.MUL);
//        main.updateInput();
//        assertEquals("2.0 + -2.01 * ", main.inputView.getText().toString());
//
//        main.operations.clear();
//        main.values.clear();
//    }
//
//    @Test
//    public void onAdd_isCorrect() {
//        main.textbox.setText("4.0");
//        main.onAdd(null);
//
//        assertEquals("4.0 + ", main.inputView.getText().toString());
//
//        main.operations.clear();
//        main.values.clear();
//    }
//
//    @Test
//    public void onSub_isCorrect() {
//        main.textbox.setText("4.0");
//        main.onSub(null);
//
//        assertEquals("4.0 - ", main.inputView.getText().toString());
//
//        main.operations.clear();
//        main.values.clear();
//    }
//
//    @Test
//    public void onMul_isCorrect() {
//        main.textbox.setText("4.0");
//        main.onMul(null);
//
//        assertEquals("4.0 * ", main.inputView.getText().toString());
//
//        main.operations.clear();
//        main.values.clear();
//    }
//
//    @Test
//    public void onDiv_isCorrect() {
//        main.textbox.setText("4.0");
//        main.onDiv(null);
//
//        assertEquals("4.0 / ", main.inputView.getText().toString());
//
//        main.operations.clear();
//        main.values.clear();
//    }
//
//    @Test
//    public void onNeg_isCorrect() {
//        main.textbox.setText("4.0");
//        main.onNeg(null);
//
//        assertEquals("-4.0", main.textbox.getText().toString());
//
//        main.onNeg(null);
//
//        assertEquals("4.0", main.textbox.getText().toString());
//    }
//
//    @Test
//    public void onClr_isCorrect() {
//        main.textbox.setText("5.2");
//        main.operations.add(main.MUL);
//        main.operations.add(main.DIV);
//        main.values.add(2.0);
//        main.values.add(0.0);
//        main.updateInput();
//        main.onClr(null);
//
//        assertEquals("", main.textbox.getText().toString());
//        assertEquals("", main.inputView.getText().toString());
//        assert(main.operations.isEmpty());
//        assert(main.operations.isEmpty());
//
//        main.operations.clear();
//        main.values.clear();
//    }
//
//    @Test
//    public void onEql_isCorrect() {
//        main.textbox.setText("2.0");
//        main.operations.add(main.ADD);
//        main.values.add(1.0);
//        main.onEql(null);
//
//        assertEquals(3.0, main.values.get(0), 0.001);
//        assertEquals("2.0 + 1.0 = ", main.inputView.getText().toString());
//        assertEquals("3.0", main.textbox.getText().toString());
//        assert(main.operations.isEmpty());
//
//        main.operations.clear();
//        main.values.clear();
//    }
}