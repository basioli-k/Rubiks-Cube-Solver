package Cube;
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

    public String whichLayer(Cube cube, int i, int j){
        if(5<=j && j<=9 && 2<=i && i<=6){
            return "bottom";
        }
        else if(j==4 || i==1 || j == 10 || i==7){
            return "middle";
        }
        else return "top";
    }

    public boolean isRightForCross(Cube cube, int i, int j){
        if (8<=j && j<=12 && 4<=i && i<=7) return true;
        else return false;
    }
}
