package SolvingSteps;

import Cube.Cube;

import Rotations.Rotation;

public class SolveOppositeCross {
    Rotation rot = new Rotation();

    boolean isTopCrossSolved(Cube cube) {
        if (cube.cubeGrid.get(4).charAt(14) == 'y' && cube.cubeGrid.get(4).charAt(12) == 'y' &&
                cube.cubeGrid.get(3).charAt(13) == 'y' && cube.cubeGrid.get(5).charAt(13) == 'y') {
            return true;
        } else return false;
    }

    boolean canITurnTopSide(Cube cube) {
        if (cube.cubeGrid.get(4).charAt(14) == 'y' && cube.cubeGrid.get(3).charAt(13) == 'y') {
            return true;
        } else if (cube.cubeGrid.get(4).charAt(14) == 'y' && cube.cubeGrid.get(4).charAt(12) == 'y') {
            return true;
        } else if (cube.cubeGrid.get(4).charAt(14) != 'y' && cube.cubeGrid.get(4).charAt(12) != 'y' &&
                cube.cubeGrid.get(3).charAt(13) != 'y' && cube.cubeGrid.get(5).charAt(13) != 'y') {
            return true;
        } else return false;
    }

    public void oppositeCross(Cube cube) {

        while (!canITurnTopSide(cube)) {
            rot.rotateRight90(cube);
        }

        while (!isTopCrossSolved(cube)) {
            rot.F(cube);
            rot.doFourMoves(cube);
            rot.FPrime(cube);
            while (!canITurnTopSide(cube)) {
                rot.rotateRight90(cube);
            }
        }
        System.out.println("The opposite cross is solved.");
    }


}
