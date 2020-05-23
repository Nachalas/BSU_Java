import com.company.BubbleSort;
import com.company.ConsoleArrayInput;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ConsoleArrayInput input = new ConsoleArrayInput();
        ArrayList<Integer> test = input.input();
        BubbleSort sort = new BubbleSort();
        sort.BubbleSort(test);
        for(var i : test) {
            System.out.println(i + " ");
        }
    }
}
