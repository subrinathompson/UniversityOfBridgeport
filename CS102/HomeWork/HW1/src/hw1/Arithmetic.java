package hw1;

import operator.Addition;
import operator.Division;
import operator.Multiplication;
import operator.Subtraction;

/**
 * Created by Subrina on 2/8/14.
 */
public class Arithmetic<O, T> {

    private O operator;
    private T a, b;
    private T result;

    public Arithmetic() {
        operator = null;
        a = b = null;
    }

    public Arithmetic(O operator, T a, T b) throws Exception {
        this.operator = operator;
        this.a = a;
        this.b = b;

        calculateResult();
    }

    private void doAdditionCalculation() throws Exception {
        if (a instanceof Integer) {
            Integer aIntValue = (Integer) a;
            Integer bIntValue = (Integer) b;
            result = (T) new Addition().calculate(aIntValue, bIntValue);
        } else if (a instanceof Double) {
            Double aDoubleValue = (Double) a;
            Double bDoubleValue = (Double) b;
            result = (T) new Addition().calculate(aDoubleValue, bDoubleValue);
        } else if (a instanceof Float) {
            Double aFloatValue = (Double) a;
            Double bFloatValue = (Double) b;
            result = (T) new Addition().calculate(aFloatValue, bFloatValue);
        } else {
            throw new Exception("Type cannot be determined...");
        }
    }

    private void doSubtractionCalculation() throws Exception {
        if (a instanceof Integer) {
            Integer aIntValue = (Integer) a;
            Integer bIntValue = (Integer) b;
            result = (T) new Subtraction().calculate(aIntValue, bIntValue);
        } else if (a instanceof Double) {
            Double aDoubleValue = (Double) a;
            Double bDoubleValue = (Double) b;
            result = (T) new Subtraction().calculate(aDoubleValue, bDoubleValue);
        } else if (a instanceof Float) {
            Double aFloatValue = (Double) a;
            Double bFloatValue = (Double) b;
            result = (T) new Subtraction().calculate(aFloatValue, bFloatValue);
        } else {
            throw new Exception("Type cannot be determined...");
        }
    }

    private void doMultiplicationCalculation() throws Exception {
        if (a instanceof Integer) {
            Integer aIntValue = (Integer) a;
            Integer bIntValue = (Integer) b;
            result = (T) new Multiplication().calculate(aIntValue, bIntValue);
        } else if (a instanceof Double) {
            Double aDoubleValue = (Double) a;
            Double bDoubleValue = (Double) b;
            result = (T) new Multiplication().calculate(aDoubleValue, bDoubleValue);
        } else if (a instanceof Float) {
            Double aFloatValue = (Double) a;
            Double bFloatValue = (Double) b;
            result = (T) new Multiplication().calculate(aFloatValue, bFloatValue);
        } else {
            throw new Exception("Type cannot be determined...");
        }
    }

    private void doDivisionCalculation() throws Exception {
        if (a instanceof Integer) {
            Integer aIntValue = (Integer) a;
            Integer bIntValue = (Integer) b;

            if (bIntValue == 0) {
                result = (T) "Cannot Divide by Zero";
            } else {
                result = (T) new Division().calculate(aIntValue, bIntValue);
            }
        } else if (a instanceof Double) {
            Double aDoubleValue = (Double) a;
            Double bDoubleValue = (Double) b;
            
            if (bDoubleValue == 0) {
                result = (T) "Cannot Divide by Zero";
            } else {
                result = (T) new Division().calculate(aDoubleValue, bDoubleValue);
            }
        } else if (a instanceof Float) {
            Double aFloatValue = (Double) a;
            Double bFloatValue = (Double) b;
                        
            if (bFloatValue == 0) {
                result = (T) "Cannot Divide by Zero";
            } else {
                result = (T) new Division().calculate(aFloatValue, bFloatValue);
            }
        } else {
            throw new Exception("Type cannot be determined...");
        }
    }

    private void calculateResult() throws Exception {

        if (operator != null) {
            if (operator instanceof String) {
                if (operator.equals("+")) {

                    doAdditionCalculation();
                }

                if (operator.equals("-")) {

                    doSubtractionCalculation();
                }

                if (operator.equals("*")) {

                    doMultiplicationCalculation();
                }

                if (operator.equals("/")) {

                    doDivisionCalculation();
                }
            } else if (operator instanceof Character) {
                if (operator.equals('+')) {

                    doAdditionCalculation();
                }

                if (operator.equals('-')) {

                    doSubtractionCalculation();
                }

                if (operator.equals('*')) {

                    doMultiplicationCalculation();
                }

                if (operator.equals('/')) {

                    doDivisionCalculation();
                }
            } else {
                throw new Exception("Type cannot be determined...");
            }
        }
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    public O getOperator() {
        return operator;
    }

    public void setOperator(O operator) {
        this.operator = operator;
    }

    public T getResult() {
        return result;
    }
        

    @Override
    public String toString() {
        StringBuilder reportString = new StringBuilder();
        reportString.append(a).append("\t").append(operator).append("\t").append(b).append("\t= ").append(result);
        reportString.append("\n");

        return reportString.toString();
    }
}
