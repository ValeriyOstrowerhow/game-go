import java.util.Scanner;

public class game {
  private static String[][] field = new String[10][10];
  private static byte PlayerNumber = 0;
  protected static int countpass = 0;

  public static void CreatingTheInitialField() {
    for (int i = 1; i < 10; i++) {
      field[0][0] = "";
      field[0][1] = "a";
      field[0][2] = "b";
      field[0][3] = "c";
      field[0][4] = "d";
      field[0][5] = "e";
      field[0][6] = "f";
      field[0][7] = "g";
      field[0][8] = "h";
      field[0][9] = "i";

      field[1][0] = "1";
      field[2][0] = "2";
      field[3][0] = "3";
      field[4][0] = "4";
      field[5][0] = "5";
      field[6][0] = "6";
      field[7][0] = "7";
      field[8][0] = "8";
      field[9][0] = "9";

      for (int j = 1; j < 10; j++) {
        field[i][j] = "+";
      }
    }
    game.PrintingTheField();
  }

  // Todo: добавить допметод для "addingStonesToTheField", чтобы уменьшить код и учесть некоректный ввод
  public static Object addingStonesToTheField(Scanner scanner) {
    nextPlayer();
    System.out.println("Сейчас ход " + (1 == PlayerNumber ? "чёрных!" : "белых!"));
    System.out.print("Введите \"+\" чтобы сделать пасс и \"-\" чтобы его не делать: ");

    String pass = scanner.nextLine();
    String plus = "+";
    String minus = "-";
    if (pass.equals(plus)) {
      countpass++;
      game.PrintingTheField();
      return null;
    } else if (pass.equals(minus)) {
      countpass = 0;
    }
    System.out.print("Введите поле на которое хотите поставить камень: ");

    while (scanner.hasNext()) {
      String place = scanner.nextLine().toLowerCase();
      char n = place.charAt(0);
      if (n > 58) {
        String letter = String.valueOf(place.charAt(0));
        String number = String.valueOf(place.charAt(1));
        for (int i = 1; i < 10; i++) {
          for (int j = 1; j < 10; j++) {
            if (field[i][0].equals(number) && field[0][j].equalsIgnoreCase(letter)) {
              if (field[i][j] != "W" && field[i][j] != "B") {
                field[i][j] = (1 == PlayerNumber ? "B" : "W");
                game.PrintingTheField();
                return null;
              } else {
                System.out.print("Введённое вами поле, \"" + place + "\" уже занято введите другое место на поле: ");
                break;
              }
            }
          }
        }
      } else {
        String letter = String.valueOf(place.charAt(1));
        String number = String.valueOf(place.charAt(0));
        for (int i = 1; i < 10; i++) {
          for (int j = 1; j < 10; j++) {
            if (field[i][0].equals(number) && field[0][j].equalsIgnoreCase(letter)) {
              if (field[i][j] != "W" && field[i][j] != "B") {
                field[i][j] = (1 == PlayerNumber ? "B" : "W");
                game.PrintingTheField();
                return null;
              } else {
                System.out.print("Введённое вами поле, \"" + place + "\" уже занято введите другое место на поле: ");
                break;
              }
            }
          }
        }
      }
    }
    return null;
  }

  // Todo: улучшить дизайн поля
  private static void PrintingTheField() {
    System.out.println();
    System.out.print(field[0][0] + "    ");
    for (int j = 1; j < 10; j++) {
      System.out.print(field[0][j] + "     ");
    }
    System.out.println();

    for (int i = 1; i < 10; i++) {
      System.out.print(field[i][0] + "   ");
      for (int j = 1; j < 10; j++) {
        System.out.print(field[i][j] + "     ");
      }
      System.out.println();
      System.out.println("                                                    ");
    }
  }

  private static void nextPlayer() {
    PlayerNumber = (byte) (1 == PlayerNumber ? 2 : 1);
  }
}
