package Cube;

import Rotations.Rotation;

import java.util.Random;

public class CubeScrambler {
    Random rand = new Random();
    Rotation rot = new Rotation();
    public void scrambleCube(Cube cube){
        int randomNumber = 1 + rand.nextInt(12);
        int moves = 0;
        System.out.println("Scrambling: ");
        while(moves < 30){
            switch(randomNumber){
                case 1:
                    rot.R(cube);
                    System.out.println("R");

                    break;
                case 2:
                    rot.RPrime(cube);
                    System.out.println("R prime");
                    break;
                case 3:
                    rot.L(cube);
                    System.out.println("L");
                    break;
                case 4:
                    rot.LPrime(cube);
                    System.out.println("L prime");
                    break;
                case 5:
                    rot.M(cube);
                    System.out.println("M");
                    break;
                case 6:
                    rot.MPrime(cube);
                    System.out.println("M prime");
                    break;
                case 7:
                    rot.rotateRight90(cube);
                    System.out.println("Rotate right 90");
                    break;
                case 8:
                    rot.X(cube);
                    System.out.println("X");
                    break;
                case 9:
                    rot.XPrime(cube);
                    System.out.println("X prime");
                    break;
                case 10:
                    rot.U(cube);
                    System.out.println("U");
                    break;
                case 11:
                    rot.UPrime(cube);
                    System.out.println("U Prime");
                    break;
                case 12:
                    rot.rotateLeft90(cube);
                    System.out.println("Rotate left 90");
                    break;

            }

            randomNumber = 1 + rand.nextInt(12);
            ++moves;
        }
    }
}
