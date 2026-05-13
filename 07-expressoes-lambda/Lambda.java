import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda {    
    static List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
    static List<Integer> numerosPares = new ArrayList<>();
    public static void main(String[] args) {       

        /*for (Integer numero : numeros) {
            System.out.println("Número: " + numero);
        }*/

        numeros.forEach(numero -> {

            if(numero % 2 == 0) {
                 numerosPares.add(numero);
            }
        });     
        
        System.out.println(numerosPares);

    }    
}