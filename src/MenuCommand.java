import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public enum MenuCommand {

  READ(1, "Правила игры"),
  START (2, "Старт игры"),
  EXIT(3, "Выйти из игры"),
  UNEXPECTED(0, "");


  private final int num;
  private final String string;

  MenuCommand(int num, String string) {
    this.num = num;
    this.string = string;
  }


  public static void menu() {
    System.out.println();
    System.out.println(" ═-═-═-═-═-═ Добро пожаловать в Игру Го ═-═-═-═-═-═ ");

    System.out.println(" ===================  〚 МЕНЮ 〛 ===================\n");

    for (MenuCommand command : values()) {
      if (command != UNEXPECTED) {
        System.out.println(command.num + ". " + command.string);
      }
    }
  }

  public static MenuCommand commandList() throws FileNotFoundException {

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
            System.out.println("Вы выбрали: " + READ.string);
            File gofile = new File("res/go.txt");
            Scanner scannerFile = new Scanner(gofile);

            while (scannerFile.hasNextLine()) {
              String line = scannerFile.nextLine();
              System.out.println(line);
            }
            scannerFile.close();
            break;

          case 2:
            System.out.println("Вы выбрали: " + START.string);
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
