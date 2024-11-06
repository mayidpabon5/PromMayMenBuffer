import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String Ruta = "D:\\Semillero\\test.txt";
        File file = new File(Ruta);
        if (file.exists()) {
            System.out.println("El archivo existe");
        }
        ArrayList<Integer> calificaciones = new ArrayList<>();
        try (FileReader fr = new FileReader(Ruta)) {
            BufferedReader br = new BufferedReader(fr);
            String dato;
            while ((dato = br.readLine()) != null) {
                try {
                    int agregar = Integer.parseInt(dato);
                    calificaciones.add(agregar);
                } catch (Exception e) {
                    System.out.println("Estos datos no son tenidos en cuenta para las operaciones: " + dato);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double suma = 0;
        double indice = 0;
        for (int a : calificaciones) {
            suma = suma + a;
            indice = indice + 1;
        }
        int mayor = 0;
        for (int a : calificaciones) {
            if (a >= mayor) {
                mayor = a;
            }
        }
        int menor = calificaciones.getFirst();
        for (int a : calificaciones) {
            if (a < menor) {
                menor = a;
            }
        }
        double promedio = suma / indice;
        System.out.println("El promedio de calificaciones es: " + promedio);
        System.out.println("La calificación mas alta es: " + mayor);
        System.out.println("La calificación menor es: " + menor);

    }
}