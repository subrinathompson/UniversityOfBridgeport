package hw1;

import java.util.ArrayList;

/**
 * Created by Subrina on 2/8/14.
 * @param <O>
 * @param <T>
 */
public class Report<O, T> {
    private ArrayList<Arithmetic<O,T>> data;

    public Report() {
        data = new ArrayList<Arithmetic<O, T>>();
    }

    public ArrayList<Arithmetic<O, T>> getData() {
        return data;
    }

    public void setData(ArrayList<Arithmetic<O, T>> data) {
        this.data = data;
    }

    @Override
    public String toString() {

        StringBuilder reportString = new StringBuilder("===============================================================\n");
        reportString.append("===========SIMULATION OF RANDOM ARITHMETIC GENERATOR===========");
        reportString.append("\n===============================================================\n");

        for (Arithmetic a : data) {
            reportString.append("\t\t").append(a);
        }

        return reportString.toString();
    }
}
