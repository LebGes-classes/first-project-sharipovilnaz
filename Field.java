package Game;

class Field {
    private char[][] matrixOfMaze;
    private int playerX;
    private int playerY;
    private int exitX;
    private int exitY;

    public void createField(int level) {
        switch (level) {
            case 1:
                matrixOfMaze = new char[][]{
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', 'P', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
                    {'#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', '#', '#', '#', '#', '#', 'E', '#'},
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
                };
                break;
            case 2:
                matrixOfMaze = new char[][]{
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', 'P', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
                    {'#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#'},

                    {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', '#', '#', '#', '#', '#', 'E', '#'},
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
                };
                break;
            case 3:
                matrixOfMaze = new char[][]{
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', 'P', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
                    {'#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', '#', '#', '#', '#', '#', 'E', '#'},
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
                };
                break;
            default:
                System.out.println("Неверный уровень!");
                return;
        }

        // Находим позицию игрока и выхода
        for (int i = 0; i < matrixOfMaze.length; i++) {
            for (int j = 0; j < matrixOfMaze[i].length; j++) {
                if (matrixOfMaze[i][j] == 'P') {
                    playerX = i;
                    playerY = j;
                } else if (matrixOfMaze[i][j] == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }
    }

    public void printField() {
        for (char[] row : matrixOfMaze) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public char[][] getMatrixOfMaze() {
        return matrixOfMaze;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerPosition(int x, int y) {
        matrixOfMaze[playerX][playerY] = ' ';
        playerX = x;
        playerY = y;
        matrixOfMaze[playerX][playerY] = 'P';
    }

    public boolean isExitReached() {
        return playerX == exitX && playerY == exitY;
    }
}

