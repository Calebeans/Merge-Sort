import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //int []vecto = {99,8,11,20,30,47,51,57,7,17,20,25,40,70,90};
        //int []vectoAux = new int[vecto.length];

        //mergeSort(vecto, vectoAux,0,vecto.length-1);

        //System.out.println(Arrays.toString(vecto));

        String vecto[] = new String[29855];
        String vectoAux[] = new String[29855];
        int i = 0;

        Path arquivo = Paths.get("C:/Users/Calebe/Documents/GitHub/TrabalhoOrdenacao/Arquivos/Instâncias-TP1/DicionarioAleatorio-29855.txt");

        try{
            List<String> linhas = Files.readAllLines(arquivo);
            for (String linha:linhas){
                vecto[i] = linha;
                i++;
                //System.out.println(linha);
            }
        }catch (Exception e){
            System.out.println("Erro");
        }

        mergeSort(vecto, vectoAux, 0, 29854);

        System.out.println("Ordenado:");
        System.out.println(Arrays.toString(vecto));

    }

    private static void mergeSort(String[] lista, String[] listaAux, int inicio, int fim){
        int meio;
        int cont = 0;
        if(inicio < fim){
            meio = (inicio + fim) / 2;
            mergeSort(lista, listaAux, inicio, meio);
            mergeSort(lista, listaAux, meio+1, fim);
            intercala(lista, listaAux, inicio, meio, fim);
            cont++;
        }

        System.out.println("Trocas: " + cont);
    }

    private static void intercala(String[] lista, String[] listaAux, int inicio, int meio, int fim){
        int i,j;

        for (i=inicio; i<=fim; i++){
            listaAux[i] = lista[i];
        }
        i = inicio;
        j = meio + 1;

        for (int k = inicio; k <=fim; k++){
            if (i > meio) lista[k] = listaAux[j++];
            else if (j > fim) lista[k] = listaAux[i++];
            else if (listaAux[i].compareTo(listaAux[j]) < 0) lista[k] = listaAux[i++];
            else lista[k] = listaAux[j++];
        }
    }

}