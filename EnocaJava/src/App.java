public class App {
    public static void main(String[] args) throws Exception {
         // Aritmetik İlerleme
         int ilk_terim = 2;
         int fark = 2;
 
         for (int i = 1; i <= 5; i++) {
             if (i == 1) {
                 System.out.println("*");
             }
             for (int j = 0; j < ilk_terim + (i - 1) * fark; j++) {
                 System.out.print("*");
             }
             System.out.println();
         }
    }
}
