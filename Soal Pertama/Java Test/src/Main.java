import java.util.*;

public class Main {

    public static void main(String[] args) {
        satuA(); //jawaban no 1 A
        satuB(); //jawaban no 1 B
    }

    static void satuA() {
        String[] array1 = {"Satu", "Dua", "Tiga", "Lima"};
        String[] array2 = {"Tiga", "Empat", "Lima", "Enam"};
        ArrayList<String> hasilArray = new ArrayList<>();

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equals(array2[j])) {
                    hasilArray.add(array1[i]);
                }
            }
        }

        Collections.sort(hasilArray);
        System.out.print("A. ");
        System.out.println(hasilArray);
    }

    static void satuB() {

    }

}