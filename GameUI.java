package Game;

import java.util.Scanner;

class GameUI {
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); // ANSI-код для очистки консоли
                System.out.flush();
            }
        } catch (Exception e) {
            // Если очистка не удалась, просто выводим много пустых строк
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public void displayMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("|          Добро пожаловать в игру 'Лабиринт'!    |");
        System.out.println("|          1. Начать новую игру                   |");
        System.out.println("|          2. Правила игры                        |");
        System.out.println("|          3. Выйти                               |");
        System.out.println("---------------------------------------------------");
    }

    public void displayRules() {
        clearConsole();
        System.out.println("---------------------------------------------------");
        System.out.println("|                  Правила игры:                  |");
        System.out.println("| Используйте клавиши W, A, S, D для перемещения: |");
        System.out.println("| W - Вверх, S - Вниз, A - Влево, D - Вправо.     |");
        System.out.println("| Ваша цель — найти выход (E) из лабиринта.       |");
        System.out.println("| Нажмите Enter, чтобы вернуться в меню...        |");
        System.out.println("---------------------------------------------------");
        new Scanner(System.in).nextLine(); // Очистка буфера
    }
}
