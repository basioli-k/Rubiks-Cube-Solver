package Cube;

import Rotations.Rotation;
import SolvingSteps.SolveCross;

public class CubeSolver {
    Rotation rot = new Rotation();
    public void solveCube(Cube cube){
        SolveCross crossSolver = new SolveCross();
        System.out.println("Solving: ");
        //rot.FPrime(cube);
        //
        crossSolver.formWhiteCross(cube);
    }
}
