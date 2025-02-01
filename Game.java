package Game;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        GameUI gameUI = new GameUI();
        Field field = new Field();
        Movement movement = new Movement(field);
        Scanner scan = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            gameUI.displayMenu();
            int input = scan.nextInt();

            switch (input) {
                case 1:
                    GameUI.clearConsole();
                    System.out.print("Выберите уровень (1, 2, 3): ");
                    int level = scan.nextInt();
                    GameUI.clearConsole();
                    field.createField(level);
                    field.printField();
                    movement.movePlayer();
                    break;
                case 2:
                    GameUI.clearConsole();
                    gameUI.displayRules();
                    GameUI.clearConsole();
                    break;
                case 3:
                    isRunning = false;
                    GameUI.clearConsole();
                    System.out.println("Выход из игры...");
                    break;
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }
}

