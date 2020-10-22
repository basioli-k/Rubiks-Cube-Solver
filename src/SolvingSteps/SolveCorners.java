package SolvingSteps;

import Cube.Cube;
import Cube.CubeExplorer;
import Rotations.Rotation;

public class SolveCorners {
    Rotation rot = new Rotation();
    void rotateCube(Cube cube){
        rot.X(cube);
        rot.X(cube);
    }
    public void cornerSolving(Cube cube){
        rotateCube(cube);
        for(int i = 0 ; i < 4; ++i){
            while(cube.cubeGrid.get(5).charAt(8) != 'y'){
                rot.doFourMoves(cube);
            }
            rot.B(cube);
        }
        rotateCube(cube);
        System.out.println("Corners are solved.");

    }
}
