package SolvingSteps;

import Cube.Cube;
import Cube.CubeExplorer;
import Rotations.Rotation;

public class OrientOppositeCross {
    Rotation rot = new Rotation();
    CubeExplorer cubeExp = new CubeExplorer();

    boolean isEdgeCorrect(Cube cube, char color){
        boolean edgeCorrect = false;
        int [][] edge = cubeExp.findEdge(cube,color,'y');

        if(edge[0][0] == 0 && edge[0][1] == 7 && color == cube.cubeGrid.get(1).charAt(7)){
            edgeCorrect = true;
        }
        else if(edge[0][0] == 4 && edge[0][1] == 3 && color == cube.cubeGrid.get(4).charAt(4)){
            edgeCorrect = true;
        }
        else if(edge[0][0] == 4 && edge[0][1] == 11 && color == cube.cubeGrid.get(4).charAt(10)){
            edgeCorrect = true;
        }
        else if(edge[0][0] == 8 && edge[0][1] == 7 && color == cube.cubeGrid.get(7).charAt(7)){
            edgeCorrect = true;
        }
        return edgeCorrect;
    }
    boolean canITurnTopSide(Cube cube){
        char[] colors = {'r','b','o','g'};
        int count = 0;
        for(int i = 0; i < 4; ++i){
            if(isEdgeCorrect(cube,colors[i])) count++;
        }
        return count == 2;
    }
    boolean oppositesAreSolved(Cube cube){
        return (isEdgeCorrect(cube,'r') && isEdgeCorrect(cube,'o')) ||
                (isEdgeCorrect(cube,'b') && isEdgeCorrect(cube,'g'));
    }

    void doOrientingRotations(Cube cube){
        rot.R(cube);
        rot.U(cube);
        rot.RPrime(cube);
        rot.U(cube);
        rot.R(cube);
        rot.UPrime(cube);
        rot.UPrime(cube);
        rot.RPrime(cube);
    }
    void setupCubeForRotation(Cube cube){
        int count = 0;
        char color;
        for(int i = 0 ; i < 4; ++i){
            color = cube.cubeGrid.get(8).charAt(7);
            if(isEdgeCorrect(cube,color)) ++count;
            else count = 0;
            if (count == 2) { rot.rotateLeft90(cube); break;}
            else rot.rotateLeft90(cube);
        }
    }


    boolean areAllEdgesCorrect(Cube cube){
        char[] colors = {'r','b','o','g'};
        int count = 0;
        for(int i = 0; i < 4; ++i){
            if(isEdgeCorrect(cube,colors[i])) count++;
        }
        return count == 4;
    }
    public void orientCross(Cube cube){
        while(!areAllEdgesCorrect(cube)){
            if(!canITurnTopSide(cube)){
                rot.U(cube);
            }
            else{
                if(oppositesAreSolved(cube)){
                    doOrientingRotations(cube);
                    rot.rotateRight90(cube);
                }
                setupCubeForRotation(cube);
                doOrientingRotations(cube);
                rot.U(cube);
            }
        }
        System.out.println("The yellow cross is oriented.");
    }
}
