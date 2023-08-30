import java.util.Scanner;

public enum MenuCommand {

  READ(1, "Правила игры"),
  START (2, "Старт игры"),
  EXIT(3, "Выйти из игры"),
  UNEXPECTED(10, "");


  private final int num;
  private final String s;

  MenuCommand(int num, String s) {
    this.num = num;
    this.s = s;
  }


  public static void menu() {
    System.out.println();
    System.out.println(" ═-═-═-═-═-═ Добро пожаловать в Игру Го ═-═-═-═-═-═ ");

    System.out.println(" ===================  〚 МЕНЮ 〛 ===================\n");

    for (MenuCommand command : values()) {
      if (command != UNEXPECTED) {
        System.out.println(command.num + ". " + command.s);
      }
    }
  }

  public static MenuCommand commandList() {

    Scanner scanner = new Scanner(System.in);
    boolean isRun = true;
    MenuCommand selectedCommand = null;
    while (isRun) {
      menu();
      System.out.println("Введите номер пункта меню: ");
      if (scanner.hasNextInt()) {
        int command = scanner.nextInt();
        scanner.nextLine();
        System.out.println("------------------------------------------------------");

        switch (command) {
          case 1:
            System.out.println("Вы выбрали: " + READ.s);
          //  gamego.read();
            selectedCommand = READ;
            break;

          case 2:
            System.out.println("Вы выбрали: " + START.s);
           // gamego.start();
            selectedCommand = START;
            break;

          case 3:
            System.out.println("До скорой встречи");
            selectedCommand = EXIT;
            isRun = false;
            break;

          default:
            selectedCommand = UNEXPECTED;
            break;

        }

      } else {
        System.err.println("Некорректный выбор. Введите корректное значение.\n");
        scanner.nextLine();
      }
    }
    return selectedCommand;
  }
}
