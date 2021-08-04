import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
// Нужно вводить координаты через пробел, от 1 до 3. Например 1 3
public class Main {
    public static void main(String[] args) {
        String[] arr = new String[]{"_", "_", "_", "_", "_", "_", "_", "_", "_"};
        String str;
        int count = 0;
        int x = 0;
        int o = 0;
        System.out.println("---------");
        for (int m = 0; m < 3; m++) {
            System.out.print("| ");
            for (int n = 0; n < 3; n++) {
                System.out.print(arr[count] + " ");
                count++;
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
        int exit = 0;

        while (exit == 0) {
            coord(arr);
            str = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
            if (str.substring(0, 3).equals("XXX")
                    || str.substring(3, 6).equals("XXX")
                    || str.substring(6, 9).equals("XXX")
                    || (str.charAt(0) == 'X') && (str.charAt(3) == 'X') && (str.charAt(6) == 'X')
                    || (str.charAt(1) == 'X') && (str.charAt(4) == 'X') && (str.charAt(7) == 'X')
                    || (str.charAt(2) == 'X') && (str.charAt(5) == 'X') && (str.charAt(8) == 'X')
                    || (str.charAt(2) == 'X') && (str.charAt(4) == 'X') && (str.charAt(6) == 'X')
                    || (str.charAt(0) == 'X') && (str.charAt(4) == 'X') && (str.charAt(8) == 'X')) {
                x = 1;
            } else if (str.substring(0, 3).equals("OOO")
                    || str.substring(3, 6).equals("OOO")
                    || str.substring(6, 9).equals("OOO")
                    || (str.charAt(0) == 'O') && (str.charAt(3) == 'O') && (str.charAt(6) == 'O')
                    || (str.charAt(1) == 'O') && (str.charAt(4) == 'O') && (str.charAt(7) == 'O')
                    || (str.charAt(2) == 'O') && (str.charAt(5) == 'O') && (str.charAt(8) == 'O')
                    || (str.charAt(2) == 'O') && (str.charAt(4) == 'O') && (str.charAt(6) == 'O')
                    || (str.charAt(0) == 'O') && (str.charAt(4) == 'O') && (str.charAt(8) == 'O')) {
                o = 1;
            }
            if (x == 1 && x + o == 1) {
                System.out.println("X wins");
                exit++;
            } else if (o == 1 && x + o == 1) {
                System.out.println("O wins");
                exit++;
            } else if (x + o == 0) {
                int draw = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == "_" || arr[i] == " ") {
                        draw++;
                    }
                }
                if (draw == 0) {
                    System.out.println("Draw");
                    exit++;
                }
            }
        }
    }

    static void coord(String[] arr) {
        Scanner scan = new Scanner(System.in);
        int ex = 0;
        String[] c;

        while (ex == 0) {
            int count2 = 0;
            int x = 0;
            int o = 0;
            try {
                System.out.print("Enter the coordinates: ");
                c = scan.nextLine().split(" ");
                int c1 = Integer.parseInt(c[0]);
                int c2 = Integer.parseInt(c[1]);
                if (c1 > 3 || c2 > 3 || c1 < 1 || c2 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 3; j++) {
                            if (c1 == i && c2 == j) {
                                if (Objects.equals(arr[count2], "X") || Objects.equals(arr[count2], "O")) {
                                    System.out.println("This cell is occupied! Choose another one!");
                                } else {
                                    for (String e : arr) {
                                        if (e == "X") {
                                            x++;
                                        } else if (e == "O") {
                                            o++;
                                        }
                                    }
                                    arr[count2] = x > o ? "O" : "X";
                                    ex++;
                                }
                            }
                            count2++;
                        }
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("You should enter numbers!");
            }
        }

        int count = 0;
        System.out.println("---------");
        for (int l = 0; l < 3; l++) {
            System.out.print("| ");
            for (int k = 0; k < 3; k++) {
                System.out.print(arr[count] + " ");
                count++;
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
}