package CodingGame;

import java.util.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 * https://www.codingame.com/ide/puzzle/there-is-no-spoon-episode-1
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }

        int i, j, temp;

        String[][] zionarray = new String[height][width];
        for (i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            String[] eachnode = line.split("");
            for (j = 0; j < width; j++)
                zionarray[i][j] = eachnode[j];
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        //String toattack = null;
        for (i = 0; i < height; i++) {
            for (j = 0; j < width; j++) {
                //toattack = "";
                if (zionarray[i][j].compareTo("0") == 0) {
                    System.out.print(j + " " + i);
                    boolean powerneighbour = false;

                    for(temp = j + 1; temp < width; temp++) {
                        if (zionarray[i][temp].compareTo("0") == 0) {
                            powerneighbour = true;
                            break;
                        }
                    }
                    if (powerneighbour)
                        System.out.print(" " + temp + " " + i);
                    else
                        System.out.print(" -1 -1");
                    
                    powerneighbour = false;
                    for(temp = i + 1; temp < height; temp++) {
                        if (zionarray[temp][j].compareTo("0") == 0) {
                            powerneighbour = true;
                            break;
                        }
                    }
                    if (powerneighbour)
                        System.out.println(" " + j + " " + temp);
                    else
                        System.out.println(" -1 -1");

                }
            }
        }

        // Three coordinates: a node, its right neighbor, its bottom neighbor
        //System.out.println("0 0 1 0 0 1");
    }
}

/*
if (i == height - 1) {
                        if (j == width - 1 || zionarray[i][j + 1].compareTo(".") == 0) {
                            System.out.println(" -1 -1 -1 -1");
                            continue;
                        }
                        if (zionarray[i][j + 1].compareTo("0") == 0) {
                            System.out.println(" " + (i + 1) + " " + j + " -1 -1");
                            continue;
                        }
                    } else if (j == width - 1) {
                        if (zionarray[i + 1][j].compareTo(".") == 0) {
                            System.out.println(" -1 -1 -1 -1");
                            continue;
                        }
                        if (zionarray[i][j + 1].compareTo("0") == 0) {
                            System.out.println(" -1 -1 " + i + " " + (j + 1));
                            continue;
                        }
                    } else {
                        if (zionarray[i][j + 1].compareTo("0") == 0)
                            System.out.print(" " + (i + 1) + " " + j);
                        else if (zionarray[i][j + 1].compareTo(".") == 0)
                            System.out.print(" -1 -1");

                        if (zionarray[i + 1][j].compareTo("0") == 0)
                            System.out.println(" " + i + " " + (j + 1));
                        else if (zionarray[i + 1][j].compareTo(".") == 0)
                            System.out.println(" -1 -1");
                }
 */