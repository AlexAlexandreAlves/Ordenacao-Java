import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.SortedSet;
import java.util.TreeSet;

public class atividadeav {
   
    // Aluno: Alex Alexandre Alves
   
    public static void main(String[] parametros) {

        SortedSet<Integer> orderArray = new TreeSet<Integer>();
        
        try {
            BufferedReader buffer = new BufferedReader(       // Usei o BufferedReader para ler o arquivo txt  
                 new FileReader("ordenacao.txt"));             // e definir o tamanho do array 
            String line = "";
            int tamanhoArray = 0;

            do {
                line = buffer.readLine();
                tamanhoArray++;

            } while (line != null);                           //Estabeleci o ponto de parada da linha
            
            int[] array = new int[tamanhoArray];              
            buffer.close();

            buffer = new BufferedReader(new FileReader("ordenacao.txt"));    //No segundo buffer estou lendo a linha
            tamanhoArray = 0;                                                // novamente para passar para o array
            do {
                line = buffer.readLine();

                if (line != null) {
                    array[tamanhoArray] = Integer.parseInt(line);
                    orderArray.add(Integer.parseInt(line));
                    tamanhoArray++;
                }
            } while (line != null);
            System.out.println(Arrays.toString(array)); // Chamei e executei os valores do array  
            bubbleSort(array);                          // Chamei e executei o método bubble sort 
            collection(array);                          // Chamei e executei a collection 

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void bubbleSort(int[] array) {          // Utilizei o método bubble sort para ordenar o array
        
        int aux = 0;
        try {
            for (int i = 0; i < (array.length) - 1; i++) {        //Fiz uso de dois for, passando os valores 
                for (int j = i + 1; j < (array.length); j++) {    //entre o array, para ordenar de forma
                    if (array[i] > array[j]) {                    //crescente
                        aux = array[i];
                        array[i] = array[j];
                        array[j] = aux;
                    }
                }
            }
            System.out.println(Arrays.toString(array));

        } catch (InputMismatchException exception) {       
            System.out.println(exception.getMessage());
        }
    }

    public static void collection(int[] array) {           //Utilizei o foreach para executar a collection list
        for (int value : array) {
            System.out.println(value);
        }
    }
}
