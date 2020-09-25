package SolvingSteps;

import Cube.Cube;
import Cube.CubeExplorer;
import Rotations.Rotation;

public class SolveCross {
    CubeExplorer cubeExp = new CubeExplorer();
    Rotation rot = new Rotation();

    boolean isPiecePositionedCorrectly(Cube cube, int i, int j, char color){
        boolean positionIsCorrect = true;
        int[] coloredCenter = cubeExp.findCenter(cube,color);

        if (coloredCenter[0] == 4 && coloredCenter[1] == 4){
            positionIsCorrect = (i==4 && j==3) || (i==4 && j==14);
        }
        else if (coloredCenter[0] == 1 && coloredCenter[1] == 7){
            positionIsCorrect = (i==0 && j==7) || (i==3 && j==13);
        }
        else if (coloredCenter[0] == 4 && coloredCenter[1] == 10){
            positionIsCorrect = (i==4 && j==11) || (i==4 && j==12);
        }
        else if (coloredCenter[0] == 7 && coloredCenter[1] == 7){
            positionIsCorrect = (i==8 && j==7) || (i==5 && j==13);
        }

        return positionIsCorrect;
    }

    boolean doColorsMatch(Cube cube, int i, int j, int k, int l){
        return cube.cubeGrid.get(i).charAt(j) == cube.cubeGrid.get(k).charAt(l);
    }
    boolean isWhiteCrossSolved(Cube cube){
        boolean isSolved = true;
        rot.orientColorDown(cube,'w');

        //this checks if a cross exists
        isSolved = isSolved && doColorsMatch(cube,4,7,4,6);
        isSolved = isSolved && doColorsMatch(cube,4,7,4,8);
        isSolved = isSolved && doColorsMatch(cube,4,7,3,7);
        isSolved = isSolved && doColorsMatch(cube,4,7,5,7);
        //this checks if a cross is in a correct place
        isSolved = isSolved && doColorsMatch(cube,4,4,4,5);
        isSolved = isSolved && doColorsMatch(cube,4,10,4,9);
        isSolved = isSolved && doColorsMatch(cube,1,7,2,7);
        isSolved = isSolved && doColorsMatch(cube,6,7,7,7);

        return isSolved;
    }
    public void formWhiteCross(Cube cube){
        char [] colors = {'r','b','g','o'};
        if(!isWhiteCrossSolved(cube)){
            for(int i = 0 ; i < 4 ; ++i){
                int[] coloredCenter = cubeExp.findCenter(cube,colors[i]);
                int[][] coloredEdge = cubeExp.findEdge(cube,colors[i],'w');
                String layer = cubeExp.whichLayer(cube,coloredEdge[0][0],coloredEdge[0][1]);

                while(!layer.equals("top")){
                    while(!layer.equals("middle")){

                        if(cubeExp.isRightForCross(cube,coloredEdge[0][0],coloredEdge[0][1])){
                            rot.R(cube);


                        }
                        else rot.rotateRight90(cube);
                        coloredEdge = cubeExp.findEdge(cube,colors[i],'w');
                        layer = cubeExp.whichLayer(cube,coloredEdge[0][0],coloredEdge[0][1]);
                    }

                    if(cubeExp.isRightForCross(cube,coloredEdge[0][0],coloredEdge[0][1])){
                        if(coloredEdge[0][0] == 7 && coloredEdge[0][1] == 8){
                            rot.FPrime(cube);
                            rot.U(cube);
                            rot.F(cube);


                        }
                        else{
                            rot.R(cube);
                            rot.U(cube);
                            rot.RPrime(cube);


                        }
                    }
                    else rot.rotateRight90(cube);
                    coloredEdge = cubeExp.findEdge(cube,colors[i],'w');
                    layer = cubeExp.whichLayer(cube,coloredEdge[0][0],coloredEdge[0][1]);
                }

                while(!isPiecePositionedCorrectly(cube,coloredEdge[0][0],coloredEdge[0][1],colors[i])){
                    rot.U(cube);
                    coloredEdge = cubeExp.findEdge(cube,colors[i],'w');
                }

                while(!cubeExp.isRightForCross(cube,coloredEdge[0][0],coloredEdge[0][1])){
                    rot.rotateRight90(cube);
                    coloredEdge = cubeExp.findEdge(cube,colors[i],'w');
                }


                //slucaj kad je gore, slucaj kad nije (u gornjem sloju)
                if(coloredEdge[0][0] == 4 && coloredEdge[0][1] == 12){
                    rot.RPrime(cube);
                    rot.FPrime(cube);
                    rot.UPrime(cube);
                    rot.F(cube);
                    rot.R(cube);
                    rot.R(cube);


                }
                else{
                    rot.R(cube);
                    rot.R(cube);


                }

                if(isWhiteCrossSolved(cube)) break;
            }
        }
        System.out.println("Cross is formed");
    }
}
