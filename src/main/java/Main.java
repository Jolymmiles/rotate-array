import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] all_array = new String[n][n];
        for (int lines = 0; lines < n; lines++) {
            //Scanner sc1 = new Scanner(System.in);
            //String input_line = sc1.nextLine();
            String[] data = sc.nextLine().split(" ");
            for (int columns = 0; columns < n; columns++) {
                all_array[lines][columns] = data[columns];
            }
        }
        String[][] new_array = new String[n][n];
        for (int lines = 0; lines < n; lines++) {
            for (int columns = 0; columns < n; columns++) {
                new_array[lines][columns] = all_array[columns][lines];
            }
        }
        for (int s = 0; s < n; s++) {
            for (int c = 0; c < n; c++) {
                System.out.print(Integer.parseInt(new_array[s][c])+ "\t");
            }
            System.out.println();
        }
    }
}