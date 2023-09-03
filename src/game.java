public class game {
  private static String[][] field = new String[10][10];
  public static void fieldCallMethod() {
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

  public static void addingStonesToTheField() {
    System.out.println();
    System.out.print("Введите поле на которое хотите поставить камень: ");
    // для начала отталкиваемся от того что человек сначала вводит маленькую букву а потом цифру


  }
}
