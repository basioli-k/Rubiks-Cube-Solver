package Cube;

import Rotations.Rotation;
import SolvingSteps.SolveCross;

public class CubeSolver {
    public void solveCube(Cube cube){
        SolveCross crossSolver = new SolveCross();
        System.out.println("Solving: ");
        crossSolver.formWhiteCross(cube);
    }
}
