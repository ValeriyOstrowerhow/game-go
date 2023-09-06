import java.io.FileNotFoundException;

public class gamego {
  // -Человеку предлагают 3 варианта, в консоли, либо ознакомиться с правилами и самой игрой, либо приглашение на игру
  // "начать игру" или "выход".

  //   -Если человек выбирает 1 вариант, ему дают историю и правила игры (обобщённо об игре).

  //   -Если человек выбирает 2 вариант, (в идеале ему дают 3 основных варианта доски и вариант доски с таким размером
  //   который он сам игрок хочет, не идеальный сценарий дают 3 варианта доски 19-19, 13-13, 9-9),
  //   и после этого старт игры.

  //     *то что высвечивается только при начале
  //     последовательность действий при старте:
  //     -*"добро пожаловать в игру жилаем вам удачной и запоминающееся партии!"
  //     -*И предлагается выбрать кто кем будет играть "Но прежде чем вы начнёте игру с вашим соперником определитесь кто какими камнями будет играть"
  //     -Также даётся щётчик сколько кто комней забрал
  //     -При старте даётся поле 9-9
  //     -И напоминает чей сейчас ход например ("сейчас ход чёрных")
  //     И сразу после этого говорит "Введите поле на которое хотите поставить камень: "

  //     В том случаи если игрок пытается поставить камень в то место где у его камня нет дыханий игра предупреждает что такой ход не возможен:
  //     "вы хотите поставить камень туда где у вашего камня нет дыханий, подобный ход запрещён игрой"
  //     По ходу действия программы у пользователя всегда есть возможность выйти а по ходу игры он всегда может сделать "пас"
  //     В конце игра подсчитывает кол. баллов и говорит кто победил, например "Белые победили с счётом x - y"




  // Добро пожаловать в игру жилаем вам удачной и запоминающееся партии!
  // Но прежде чем вы начнёте игру с вашим соперником определитесь кто какими камнями будет играть

  //    a     b     c     d     e     f     g     h     i
  // 1  +-----+-----+-----+-----+-----+-----+-----+-----+ // a1 1.0 + 0.1 = 1.1 // b1 1.0 + 0.2 = 1.2
  //    |     |     |     |     |     |     |     |     |
  // 2  +-----+-----+-----+-----+-----+-----+-----+-----+ // a2 2.0 + 0.1 = 2.1 // b2 2.0 + 0.2 = 2.2
  //    |     |     |     |     |     |     |     |     |
  // 3  +-----+-----+-----+-----0-----0-----+-----+-----+ // a3 3.0 + 0.1 = 3.1 // b3 3.0 + 0.2 = 3.22
  //    |     |     |     |     |     |     |     |     |
  // 4  +-----+-----+-----0-----p-----p-----0-----+-----+ // a x.0 + 0.x = x.2 // b
  //    |     |     |     |     |     |     |     |     |
  // 5  +-----+-----+-----+-----0-----0-----+-----+-----+ // 1+0=1 0+0=0 1.0+1 //
  //    |     |     |     |     |     |     |     |     |
  // 6  +-----+-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 7  +-----B-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 8  +-----W-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 9  +-----+-----+-----+-----+-----+-----+-----+-----+

  // Сейчас ход чёрных
  // Введите чтобы сделать пас "+":
  // Введите поле на которое хотите поставить камень: 1a

  // Выйти из программы, введите 3:

  //      3      4     4     3     4     3     4     4
  //    a     b     c     d     e     f     g     h     j
  //    |     |     |     |     |     |     |     |     |
  // 2  ⓞ-----+-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 3  +-----+-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 4  +-----+-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 5  +-----+-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 6  +-----+-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 7  +-----+-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 8  +-----+-----+-----+-----+-----+-----+-----+-----+
  //    |     |     |     |     |     |     |     |     |
  // 9  +-----+-----+-----+-----+-----+-----+-----+-----+

  // сейчас ход белых

  // Введите поле на которое хотите поставить камень: a2

  // потом ход чёрных и опять белых




  //     игрок "1" ходит первый черными фишками а игрок "2" белыми (игра происходит на одном устройстве)
  //     После игра говорит что ход белых и также "Введите поле на которое хотите поставить камень"

  //   -Если человек выбирает 3 вариант, он выходит из игры.

  // *Как программе понять что фишк(у;и) одного игрока захватили
  // *Подсчёт баллов в конце игры
  // *Как будет работать поле го

  public static void main(String[] args) throws FileNotFoundException {
    MenuCommand.commandList();
  }
}
