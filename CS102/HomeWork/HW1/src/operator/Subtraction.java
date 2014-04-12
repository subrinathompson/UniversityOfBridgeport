package operator;

/**
 * Created by Subrina on 2/8/14.
 */
public class Subtraction implements Operator {

    @Override
    public Double calculate(Double op1, Double op2) {
        return op1 - op2;
    }

    @Override
    public Integer calculate(Integer op1, Integer op2) {
        return op1 - op2;
    }

    @Override
    public Float calculate(Float op1, Float op2) {
        return op1 - op2;
    }
}
