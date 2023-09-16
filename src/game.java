import java.util.Scanner;

public class game {
  private static String[][] field = new String[10][10];
  private static byte PlayerNumber = 0;
  public static int countpass = 0;

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
  public static boolean addingStonesToTheField(Scanner scanner, boolean isRun2) {
    nextPlayer();
    System.out.println("Сейчас ход " + (1 == PlayerNumber ? "чёрных!" : "белых!"));
    isRun2 = game.Pass(scanner, isRun2);
    if (isRun2 == false) {
      return isRun2;
    }
    System.out.print("Введите поле на которое хотите поставить камень: ");

    while (scanner.hasNext()) {
      String place = scanner.nextLine().toLowerCase();
      String[] plaseinfield = game.substring(place);
      String letter = plaseinfield[0];
      String number = plaseinfield[1];
      isRun2 = game.auxiliaryMethodForAddingStones(number, letter, place, isRun2);
      if (isRun2 == false) {
        return isRun2;
      }
    }
    return isRun2;
  }

  // Todo: улучшить дизайн поля
  public static void PrintingTheField() {
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

  private static boolean Pass(Scanner scanner, boolean isRun2) {
    while (true) {
      System.out.print("Введите \"+\" чтобы сделать пасс и \"-\" чтобы его не делать: ");
      String pass = scanner.nextLine();
      String plus = "+";
      String minus = "-";

      if (pass.equals(plus)) {
        countpass++;
        game.PrintingTheField();
        isRun2 = false;
        break;
      } else if (pass.equals(minus)) {
        countpass = 0;
        break;
      } else {
        System.out.println("Вы ввели некоректное значение сделайте ввод ещё раз!");
      }
    }
    return isRun2;
  }

  private static boolean auxiliaryMethodForAddingStones(String number, String letter, String place, boolean isRun2) {
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        if (field[i][0].equals(number) && field[0][j].equalsIgnoreCase(letter)) {
          if (field[i][j] != "W" && field[i][j] != "B") {
            field[i][j] = (1 == PlayerNumber ? "B" : "W");
            game.AMethodThatLooksAtWhetherThereAreStonesNearbyAndWhatTheyAreAndThenReplacesOrDoesNotReplaceTheStoneWithAPlus();
            game.PrintingTheField();
            isRun2 = false;
            return isRun2;
          } else {
            System.out.print("Введённое вами поле, \"" + place + "\" уже занято введите другое место на поле: ");
            isRun2 = true;
            return isRun2;
          }
        }
      }
    }
    return isRun2;
  }

  private static void nextPlayer() {
    PlayerNumber = (byte) (1 == PlayerNumber ? 2 : 1);
  }

  private static String[] substring(String place) {
    String[] plaseinfield = new String[2];
    if (place.length() == 2) {
      char x = place.charAt(0); // letter
      char y = place.charAt(1); // number
      if ((x >= 97 && x <= 105) && (y >= 49 && y <= 57)) { // 49 = 1/ 57 = 9
        String letter = String.valueOf(place.charAt(0));
        String number = String.valueOf(place.charAt(1));
        plaseinfield[0] = letter;
        plaseinfield[1] = number;
      } else if ((y >= 97 && y <= 105) && (x >= 49 && x <= 57)) {
        String letter = String.valueOf(place.charAt(1));
        String number = String.valueOf(place.charAt(0));
        plaseinfield[0] = letter;
        plaseinfield[1] = number;
      } else {
        System.out.print("Даннаго места на поле нет! Ведите другое место: ");
        plaseinfield[0] = " ";
        plaseinfield[1] = " ";
      }
    } else {
      System.out.print("Даннаго места на поле нет! Ведите другое место: ");
      plaseinfield[0] = " ";
      plaseinfield[1] = " ";
    }
    return plaseinfield;
  }

  private static void AMethodThatLooksAtWhetherThereAreStonesNearbyAndWhatTheyAreAndThenReplacesOrDoesNotReplaceTheStoneWithAPlus() {

















    for (int i = 1; i < 2; i++) {
      for (int j = 2; j < 9; j++) {
        if (field[i][j] == "W") {
          if (field[i + 1][j] == "B" && field[i][j - 1] == "B" && field[i][j + 1] == "B") {
            field[i][j] = "+";
          }
        } else if (field[i][j] == "B") {
          if (field[i + 1][j] == "W" && field[i][j - 1] == "W" && field[i][j + 1] == "W") {
            field[i][j] = "+";
          }
        }
      }
    }

    for (int i = 9; i < 10; i++) {
      for (int j = 2; j < 9; j++) {
        if (field[i][j] == "W") {
          if (field[i - 1][j] == "B" && field[i][j - 1] == "B" && field[i][j + 1] == "B") {
            field[i][j] = "+";
          }
        } else if (field[i][j] == "B") {
          if (field[i - 1][j] == "W" && field[i][j - 1] == "W" && field[i][j + 1] == "W") {
            field[i][j] = "+";
          }
        }
      }
    }

    for (int i = 2; i < 9; i++) {
      for (int j = 1; j < 2; j++) {
        if (field[i][j] == "W") {
          if (field[i + 1][j] == "B" && field[i - 1][j] == "B" && field[i][j + 1] == "B") {
            field[i][j] = "+";
          }
        } else if (field[i][j] == "B") {
          if (field[i + 1][j] == "W" && field[i - 1][j] == "W" && field[i][j + 1] == "W") {
            field[i][j] = "+";
          }
        }
      }
    }

    for (int i = 2; i < 9; i++) {
      for (int j = 9; j < 10; j++) {
        if (field[i][j] == "W") {
          if (field[i + 1][j] == "B" && field[i - 1][j] == "B" && field[i][j - 1] == "B") {
            field[i][j] = "+";
          }
        } else if (field[i][j] == "B") {
          if (field[i + 1][j] == "W" && field[i - 1][j] == "W" && field[i][j - 1] == "W") {
            field[i][j] = "+";
          }
        }
      }
    }




    if (field[1][1] == "W") {
      if (field[1 + 1][1] == "B" && field[1][1 + 1] == "B") {
        field[1][1] = "+";
      }
    } else if (field[1][1] == "B") {
      if (field[1 + 1][1] == "W" && field[1][1 + 1] == "W") {
        field[1][1] = "+";
      }
    }

    if (field[1][9] == "W") {
      if (field[1 + 1][9] == "B" && field[1][9 - 1] == "B") {
        field[1][9] = "+";
      }
    } else if (field[1][9] == "B") {
      if (field[1 + 1][9] == "W" && field[1][9 - 1] == "W") {
        field[1][9] = "+";
      }
    }

    if (field[9][9] == "W") {
      if (field[9 - 1][9] == "B" && field[9][9 - 1] == "B") {
        field[9][9] = "+";
      }
    } else if (field[9][9] == "B") {
      if (field[9 - 1][9] == "W" && field[9][9 - 1] == "W") {
        field[9][9] = "+";
      }
    }

    if (field[9][1] == "W") {
      if (field[9 - 1][1] == "B" && field[9][1 + 1] == "B") {
        field[9][1] = "+";
      }
    } else if (field[9][1] == "B") {
      if (field[9 - 1][1] == "W" && field[9][1 + 1] == "W") {
        field[9][1] = "+";
      }
    }





    for (int i = 2; i < 9; i++) {
      for (int j = 2; j < 9; j++) {
        if (field[i][j] == "W") {
          if (field[i - 1][j] == "B" && field[i + 1][j] == "B" && field[i][j - 1] == "B" && field[i][j + 1] == "B") {
            field[i][j] = "+";
          }
        } else if (field[i][j] == "B") {
          if (field[i - 1][j] == "W" && field[i + 1][j] == "W" && field[i][j - 1] == "W" && field[i][j + 1] == "W") {
            field[i][j] = "+";
          }
        }
      }
    }




  }
}
