import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public enum MenuCommand {

  READ(1, "Правила и история игры"),
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
    System.out.println();
    System.out.println(" ═-═-═-═-═-═ Добро пожаловать в Игру Го ═-═-═-═-═-═ ");
    while (isRun) {
      menu();
      System.out.print("Введите номер пункта меню: ");
      if (scanner.hasNextInt()) {
        int command = scanner.nextInt();
        scanner.nextLine();
        System.out.println("------------------------------------------------------");

        switch (command) {
          case 1:
            File gofile = new File("res/go.txt");
            Scanner scannerFile = new Scanner(gofile);

            while (scannerFile.hasNextLine()) {
              String line = scannerFile.nextLine();
              System.out.println(line);
            }
            scannerFile.close();
            selectedCommand = READ;
            break;

          case 2:
            System.out.println("Добро пожаловать в игру жилаем вам удачной и запоминающееся партии!");
            System.out.println("Но должны предупредить! Прежде чем вы начнёте игру с вашим соперником определитесь кто какими камнями будет играть");

            game.CreatingTheInitialField();
            while (game.countpass < 2) {
              boolean isRun2 = true;
              while (isRun2) {
                isRun2 = game.addingStonesToTheField(scanner, isRun2); // Передайте isRun2 в метод addingStonesToTheField
              }
              if (game.countpass == 2) {
                System.out.println("--------------Удачи в следующей игре за игру!--------------");
                System.out.println();
                game.countpass = 0;
                break; // Выход из цикла while (game.countpass < 2)
              }
            }

            selectedCommand = START;
            break;

          case 3:
            System.out.println("До скорой встречи и спасибо за игру!");
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
