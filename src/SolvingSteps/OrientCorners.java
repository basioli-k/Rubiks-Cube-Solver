package SolvingSteps;

import Cube.Cube;
import Cube.CubeExplorer;
import Rotations.Rotation;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class OrientCorners {
    CubeExplorer cubeExp = new CubeExplorer();
    Rotation rot = new Rotation();
    boolean isCornerOriented(Cube cube, char color1, char color2){
        boolean oriented = false;
        int [][] corner = cubeExp.findCorner(cube,color1,color2,'y');

        if((corner[0][0] == 0 && corner[0][1] == 6) || (corner[1][0] == 0 && corner[1][1] == 6) || (corner[2][0] == 0 && corner[2][1] == 6) ){

            oriented = (color1 == cube.cubeGrid.get(4).charAt(4) && color2 == cube.cubeGrid.get(1).charAt(7)) ||
                    (color2 == cube.cubeGrid.get(4).charAt(4) && color1 == cube.cubeGrid.get(1).charAt(7));
        }
        else if((corner[0][0] == 5 && corner[0][1] == 3) || (corner[1][0] == 5 && corner[1][1] == 3) || (corner[2][0] == 5 && corner[2][1] == 3)){

            oriented = (color1 == cube.cubeGrid.get(4).charAt(4) && color2 == cube.cubeGrid.get(7).charAt(7)) ||
                    (color2 == cube.cubeGrid.get(4).charAt(4) && color1 == cube.cubeGrid.get(7).charAt(7));
        }
        else if((corner[0][0] == 8 && corner[0][1] == 8) || (corner[1][0] == 8 && corner[1][1] == 8) || (corner[2][0] == 8 && corner[2][1] == 8)){

            oriented = (color1 == cube.cubeGrid.get(4).charAt(10) && color2 == cube.cubeGrid.get(7).charAt(7)) ||
                    (color2 == cube.cubeGrid.get(4).charAt(10) && color1 == cube.cubeGrid.get(7).charAt(7));
        }
        else if((corner[0][0] == 3 && corner[0][1] == 11) || (corner[1][0] == 3 && corner[1][1] == 11) || (corner[2][0] == 3 && corner[2][1] == 11) ){
            oriented = (color1 == cube.cubeGrid.get(4).charAt(10) && color2 == cube.cubeGrid.get(1).charAt(7)) ||
                    (color2 == cube.cubeGrid.get(4).charAt(10) && color1 == cube.cubeGrid.get(1).charAt(7));
        }
        return oriented;
    }

    public boolean areAllCornersOriented(Cube cube){
        boolean allAreOriented = true;
        char [][] colorPairs = {{'r','b'},{'o','g'},{'r','g'},{'o','b'}};
        for(int i = 0 ; i < colorPairs.length ; ++i){
            allAreOriented = allAreOriented && isCornerOriented(cube,colorPairs[i][0],colorPairs[i][1]);

        }
        return allAreOriented;
    }

    void orientCornersRotation(Cube cube){
        rot.U(cube);
        rot.R(cube);
        rot.UPrime(cube);
        rot.LPrime(cube);
        rot.U(cube);
        rot.RPrime(cube);
        rot.UPrime(cube);
        rot.L(cube);
    }

    public void orientCorners(Cube cube){

        int tooManyTurns = 0;
        boolean atLeastOneCornerIsOriented = false;
        while(!areAllCornersOriented(cube)) {


            char color1 = cube.cubeGrid.get(8).charAt(8) == 'y' ? cube.cubeGrid.get(5).charAt(11) : cube.cubeGrid.get(8).charAt(8);
            char color2 = cube.cubeGrid.get(8).charAt(8) == 'y' ? cube.cubeGrid.get(5).charAt(12) :
                    cube.cubeGrid.get(5).charAt(12) == 'y' ? cube.cubeGrid.get(5).charAt(11) : cube.cubeGrid.get(5).charAt(12);

            if (!isCornerOriented(cube, color1, color2) || tooManyTurns == 5) {
                tooManyTurns++;
                rot.rotateRight90(cube);
            }

            if(tooManyTurns == 5) {orientCornersRotation(cube); tooManyTurns = 0;} // tooManyTurns = 0;}
            if (isCornerOriented(cube, color1, color2)) {orientCornersRotation(cube);}



        }
        System.out.println("Corner orientation finished.");
    }
}
