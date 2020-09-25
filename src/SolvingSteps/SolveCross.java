package SolvingSteps;

import Cube.Cube;
import Cube.CubeExplorer;
import Rotations.Rotation;

public class SolveCross {
    CubeExplorer cubeExp = new CubeExplorer();
    Rotation rot = new Rotation();
    boolean doColorsMatch(Cube cube, int i, int j, int k, int l){
        return cube.cubeGrid.get(i).charAt(j) == cube.cubeGrid.get(k).charAt(l);
    }
    boolean isWhiteCrossSolved(Cube cube){
        boolean isSolved = true;
        rot.orientColorDown(cube,'w');
        int [] whiteCoordinates = {4,7};
        char [] colors = {'r','b','g','o'};
        isSolved = isSolved && doColorsMatch(cube,4,4,4,5);
        isSolved = isSolved && doColorsMatch(cube,4,10,4,9);
        isSolved = isSolved && doColorsMatch(cube,1,7,2,7);
        isSolved = isSolved && doColorsMatch(cube,6,7,7,7);

        isSolved = isSolved && doColorsMatch(cube,4,7,4,6);
        isSolved = isSolved && doColorsMatch(cube,4,7,4,8);
        isSolved = isSolved && doColorsMatch(cube,4,7,3,7);
        isSolved = isSolved && doColorsMatch(cube,4,7,5,7);

        return isSolved;
    }
    public void formWhiteCross(Cube cube){
        if(!isWhiteCrossSolved(cube)){

        }
    }
}
