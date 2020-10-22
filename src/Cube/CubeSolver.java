package Cube;

import Rotations.Rotation;
import SolvingSteps.*;

public class CubeSolver {
    Rotation rot = new Rotation();
    public void solveCube(Cube cube){
        SolveCross crossSolver = new SolveCross();
        FirstTwoLayers f2l = new FirstTwoLayers();
        SolveOppositeCross solveYellowCross = new SolveOppositeCross();
        OrientOppositeCross orientYellowCross = new OrientOppositeCross();
        OrientCorners cornerOrient = new OrientCorners();
        SolveCorners cornerSolver = new SolveCorners();
        System.out.println("Solving: ");

        long start = System.nanoTime();
        crossSolver.formWhiteCross(cube);
        f2l.F2L(cube);
        solveYellowCross.oppositeCross(cube);
        orientYellowCross.orientCross(cube);
        cornerOrient.orientCorners(cube);
        cornerSolver.cornerSolving(cube);
        long end = System.nanoTime();
        System.out.println("Time needed is: " + (double) (end-start)/1000000000);
    }
}
