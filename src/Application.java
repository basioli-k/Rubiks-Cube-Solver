import Cube.Cube;
import Cube.CubeSolver;
import Cube.CubeScrambler;
import Cube.CubeExplorer;

import java.util.Scanner;

public class Application {

    static Scanner userInput = new Scanner(System.in);
    static CubeSolver cubeSolver = new CubeSolver();
    static CubeScrambler cubeScr = new CubeScrambler();
    //cubeexplorer makni
    static CubeExplorer cubeExp = new CubeExplorer();
    public static void main(String[] args) {
        String action = "";


        while( !action.equals("e") ){
            System.out.println("Main menu: ");
            System.out.println("(s) solve");
            System.out.println("(e) exit");

            action =userInput.next();

            if(action.equals("s")){

                Cube cube = new Cube();
                //cubeScr.scrambleCube(cube);
                //System.out.println("Scrambled cube: ");
                //cube.showCube();

                cubeSolver.solveCube(cube);
                cube.showCube();
            }
        }

        System.out.println("The application is closing.");
    }
}
