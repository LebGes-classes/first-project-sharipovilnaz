package Game;

import java.util.Scanner;

public class Movement {
    private Field field;

    public Movement(Field field) {
        this.field = field;
    }

    public void movePlayer() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду (W - вверх, A - влево, S - вниз, D - вправо, Q - выход в меню): ");
            char command = scan.next().toUpperCase().charAt(0);

            if (command == 'Q') {
                break; // Выход в меню
            }

            int newX = field.getPlayerX();
            int newY = field.getPlayerY();

            switch (command) {
                case 'W':
                    newX--;
                    break;
                case 'A':
                    newY--;
                    break;
                case 'S':
                    newX++;
                    break;
                case 'D':
                    newY++;
                    break;
                default:
                    System.out.println("Неверная команда!");
                    continue;
            }

            // Проверка на стену
            if (field.getMatrixOfMaze()[newX][newY] == '#') {
                System.out.println("Вы столкнулись со стеной! Игра окончена.");
                return; // Завершаем игру
            }

            // Проверка на выход за границы
            if (newX >= 0 && newX < field.getMatrixOfMaze().length &&
                    newY >= 0 && newY < field.getMatrixOfMaze()[0].length) {
                field.setPlayerPosition(newX, newY);
            } else {
                System.out.println("Нельзя двигаться в этом направлении!");
            }

            // Очистка консоли и отображение обновленного поля
            GameUI.clearConsole();
            field.printField();

            // Проверка на выход из лабиринта
            if (field.isExitReached()) {
                System.out.println("Поздравляем! Вы нашли выход из лабиринта!");
                break;
            }
        }
    }
}