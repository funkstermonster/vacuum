package main;

/**
 * 0=room
 * 1=wall
 * 2=cleanspot
 * 3=vacuum
 */
public class Vacuum {

    private static int[][] room = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 3, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    public static void main(String[] args) {
       Vacuum vacuum = new Vacuum();
       vacuum.doVacuum(room, 1, 1);

    }

    public boolean doVacuum(int[][] room, int i, int j) {
        printRoom();
        if (isDone()) {
            return true;
        }
        if (room[i+1][j] == 0) {
            room[i][j] = 2;
            room[i+1][j] = 3;
            return doVacuum(room, i+1, j);
        }
        if (room[i][j+1] == 0) {
            room[i][j] = 2;
            room[i][j+1] = 3;
            return doVacuum(room, i, j+1);
        }
        if (room[i-1][j] == 0) {
            room[i][j] = 2;
            room[i-1][j] = 3;
            return doVacuum(room, i-1, j);
        }
        if (room[i][j-1] == 0) {
            room[i][j] = 2;
            room[i][j-1] = 3;
            return doVacuum(room, i, j-1);
        }
        return true;
    }

    public void printRoom() {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room.length; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------");
    }

    public boolean isDone() {
        boolean isDone = true;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room.length; j++) {
                if (room[i][j] != 1) {
                    isDone = false;
                    break;
                }
            }
        }
        return isDone;
    }

}
