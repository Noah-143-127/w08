import java.util.ArrayList;
import java.util.Iterator;

public class Eratosthenes {
    public static void eratosthenes(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i <= n; i++){ // create initial list
            list.add(i);
        }

        list.removeIf(next -> next % 2 == 0 && next != 2); // remove all even numbers except 2

        int i = 0;
        while(i < list.size()){
            Integer number = list.get(i);
            Integer result = number * number;
            while(result <= n){ // remove all multiples from number
                list.remove(result);
                result += number; // next multiple
            }
            i++;
        }

        for(int number: list){
            System.out.print(number + ", ");
        }
    }


    public static void main(String[] args) {
        eratosthenes(100); // gute Performance bis ca. 10_000 ab 30_000 bemerkbar langsam
    }
}