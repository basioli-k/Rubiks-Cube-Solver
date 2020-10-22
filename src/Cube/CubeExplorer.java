package Cube;

import Rotations.Rotation;

//TODO pobrinuti se za nemoguće slučajeve (ako se proslijedi u npr find edge y y)
public class CubeExplorer {

    public int[] findCenter(Cube cube, char color){
        int [] coordinates = new int[2];
        int x,y;
        for(int i = 0 ; i < cube.centerCoordinates.length ; ++i){
            x = cube.centerCoordinates[i][0];
            y= cube.centerCoordinates[i][1];

            if (cube.cubeGrid.get(x).charAt(y) == color) {
                coordinates = new int[]{x, y};
            }
        }
        return coordinates;
    }

    public int[][] findEdge(Cube cube, char color1, char color2){
        int x1,y1,x2,y2;
        int [][] coordinates = new int[2][2];
        for(int i = 0 ; i < cube.edgeCoordinates.length ; ++i){
            x1 = cube.edgeCoordinates[i][0][0];
            y1 = cube.edgeCoordinates[i][0][1];
            x2 = cube.edgeCoordinates[i][1][0];
            y2 = cube.edgeCoordinates[i][1][1];
            if (cube.cubeGrid.get(x1).charAt(y1) == color1 && cube.cubeGrid.get(x2).charAt(y2) == color2) {
                coordinates = new int[][]{{x1, y1}, {x2, y2}};
            }
            else if ((cube.cubeGrid.get(x2).charAt(y2) == color1 && cube.cubeGrid.get(x1).charAt(y1) == color2)){
                coordinates = new int[][]{{x2, y2}, {x1, y1}};
            }
        }
        return coordinates;
    }

    public int[][] findCorner(Cube cube, char color1, char color2, char color3){
        int [][] coordinates = new int [3][2];
        int x1,y1,x2,y2,x3,y3;

        for(int i = 0 ; i < cube.cornerCoordinates.length ; ++i){
            x1 = cube.cornerCoordinates[i][0][0];
            y1 = cube.cornerCoordinates[i][0][1];
            x2 = cube.cornerCoordinates[i][1][0];
            y2 = cube.cornerCoordinates[i][1][1];
            x3 = cube.cornerCoordinates[i][2][0];
            y3 = cube.cornerCoordinates[i][2][1];

            if (cube.cubeGrid.get(x1).charAt(y1) == color1 && cube.cubeGrid.get(x2).charAt(y2) == color2 &&
                    cube.cubeGrid.get(x3).charAt(y3) == color3) {
                coordinates = new int[][]{{x1, y1}, {x2, y2},{x3,y3}};
            }
            else if (cube.cubeGrid.get(x2).charAt(y2) == color1 && cube.cubeGrid.get(x3).charAt(y3) == color2  &&
                    cube.cubeGrid.get(x1).charAt(y1) == color3){
                coordinates = new int[][]{{x2, y2}, {x3, y3},{x1,y1}};
            }
            else if (cube.cubeGrid.get(x1).charAt(y1) == color1 && cube.cubeGrid.get(x3).charAt(y3) == color2  &&
                    cube.cubeGrid.get(x2).charAt(y2) == color3){
                coordinates = new int[][]{{x1, y1},{x3,y3},{x2, y2}};
            }
            else if (cube.cubeGrid.get(x2).charAt(y2) == color1 && cube.cubeGrid.get(x1).charAt(y1) == color2  &&
                    cube.cubeGrid.get(x3).charAt(y3) == color3){
                coordinates = new int[][]{{x2, y2}, {x1, y1},{x3,y3}};
            }
            else if (cube.cubeGrid.get(x3).charAt(y3) == color1 && cube.cubeGrid.get(x1).charAt(y1) == color2  &&
                    cube.cubeGrid.get(x2).charAt(y2) == color3){
                coordinates = new int[][]{{x3, y3}, {x1, y1},{x2,y2}};
            }
            else if (cube.cubeGrid.get(x3).charAt(y3) == color1 && cube.cubeGrid.get(x2).charAt(y2) == color2  &&
                    cube.cubeGrid.get(x1).charAt(y1) == color3){
                coordinates = new int[][]{{x3, y3}, {x2, y2},{x1,y1}};
            }
        }

        return coordinates;
    }

    public boolean isPiecePositionedCorrectly(Cube cube, int i, int j, char color){
        boolean positionIsCorrect = true;
        int[] coloredCenter = findCenter(cube,color);

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

    public String whichLayer(Cube cube, int i, int j){
        if(5<=j && j<=9 && 2<=i && i<=6){
            return "bottom";
        }
        else if(j==4 || i==1 || j == 10 || i==7){
            return "middle";
        }
        else return "top";
    }

    /**
     * Function returns if a piece on the position (i,j) is on the right side of the cube
     * to be more specific it returns if it is on a good right side(this excludes some things)
     * @param cube
     * @param i
     * @param j
     * @return
     */
    public boolean isRightForRotation(Cube cube, int i, int j){
        if (8<=j && j<=12 && 4<=i && i<=8) return true;
        else return false;
    }

    public boolean cornerPositionedCorrectly(Cube cube, char color1, char color2) {
        //third color is always white (for now)
        Rotation rot = new Rotation();
        boolean isCornerCorrect = true;
        while(cube.cubeGrid.get(7).charAt(7) != 'r'){
            rot.rotateRight90(cube);
        }
        int [][] coloredCorner = findCorner(cube,color1,color2,'w');

        if(color1 == 'r'){
            if(color2 == 'b'){
                isCornerCorrect = (coloredCorner[0][0] == 8 && coloredCorner[0][1] == 6) ||
                        (coloredCorner[0][0] == 5 && coloredCorner[0][1] == 3) ||
                        (coloredCorner[0][0] == 5 && coloredCorner[0][1] == 14);
            }
            else if (color2 == 'g'){
                isCornerCorrect = (coloredCorner[0][0] == 8 && coloredCorner[0][1] == 8) ||
                        (coloredCorner[0][0] == 5 && coloredCorner[0][1] == 11) ||
                        (coloredCorner[0][0] == 5 && coloredCorner[0][1] == 12);
            }
        }
        else if(color1 == 'o'){
            if(color2 == 'b'){
                isCornerCorrect = (coloredCorner[0][0] == 0 && coloredCorner[0][1] == 6) ||
                        (coloredCorner[0][0] == 3 && coloredCorner[0][1] == 3) ||
                        (coloredCorner[0][0] == 3 && coloredCorner[0][1] == 14);
            }
            else if (color2 == 'g'){
                isCornerCorrect = (coloredCorner[0][0] == 0 && coloredCorner[0][1] == 8) ||
                        (coloredCorner[0][0] == 3 && coloredCorner[0][1] == 11) ||
                        (coloredCorner[0][0] == 3 && coloredCorner[0][1] == 12);
            }
        }

        return isCornerCorrect;
    }

    public boolean sameColorUp(Cube cube, int[][] coloredEdge, int[][] coloredCorner) {
        boolean colorIsSame = false;
        for(int i = 0 ; i < 2; ++i){
            if(coloredEdge[i][1] > 11 && coloredCorner[i][1] > 11){
                colorIsSame = cube.cubeGrid.get(coloredEdge[i][0]).charAt(coloredEdge[i][1]) ==
                        cube.cubeGrid.get(coloredCorner[i][0]).charAt(coloredCorner[i][1]);
            }
        }
        return colorIsSame;
    }

    public int edgeIsCorrect(Cube cube, int[][] coloredEdge) {
        int isCorrect = 0;
        if(((coloredEdge[0][0] == 8 && coloredEdge[0][1] == 7) || (coloredEdge[1][0] == 8 && coloredEdge[1][1] == 7))  &&
                cube.cubeGrid.get(8).charAt(7) == cube.cubeGrid.get(7).charAt(7)){
            isCorrect = 1;
        }
        else if(((coloredEdge[0][0] == 4 && coloredEdge[0][1] == 11) || (coloredEdge[1][0] == 4 && coloredEdge[1][1] == 11))  &&
                cube.cubeGrid.get(4).charAt(11) == cube.cubeGrid.get(4).charAt(10)){
            isCorrect = 2;
        }
        /*else if(((coloredEdge[0][0] == 0 && coloredEdge[0][1] == 7) || (coloredEdge[1][0] == 0 && coloredEdge[1][1] == 7))  &&
                cube.cubeGrid.get(0).charAt(7) == cube.cubeGrid.get(1).charAt(7)){
            isCorrect = true;
        }
        else if(((coloredEdge[0][0] == 4 && coloredEdge[0][1] == 3) || (coloredEdge[1][0] == 4 && coloredEdge[1][1] == 3))  &&
                cube.cubeGrid.get(4).charAt(3) == cube.cubeGrid.get(4).charAt(4)){
            isCorrect = true;
        }*/

        return isCorrect;
    }

    public boolean cornerAboveEdge(Cube cube, int[][] coloredCorner, int[][] coloredEdge) {
        boolean isCornerAboveEdge = false;

        if( (coloredEdge[0][0] == 1 && coloredEdge[0][1] == 8) || (coloredEdge[0][0] == 3 && coloredEdge[0][1] == 10) ){
            isCornerAboveEdge = coloredCorner[2][0] == 3 && coloredCorner[2][1] == 12 && cube.cubeGrid.get(coloredCorner[2][0]).charAt(coloredCorner[2][1]) == 'w';
        }
        else{
            isCornerAboveEdge = coloredCorner[2][0] == 5 && coloredCorner[2][1] == 14 && cube.cubeGrid.get(coloredCorner[2][0]).charAt(coloredCorner[2][1]) == 'w';
        }
        return isCornerAboveEdge;
    }
}
