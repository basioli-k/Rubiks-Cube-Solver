package Rotations;

import Cube.Cube;
import Cube.CubeExplorer;

public class Rotation {
    RotationHelp rotHelp = new RotationHelp();

   public void R(Cube cube){
       int i1 = 3, i2 = 6, i3 = 0, i4 = 5;
       int j1 = 8, j2 = 12;

       for(int i = 0 ; i < 3 ; ++i)
       {
           cube.changeTiles(i1,j1,i2,j1);   // bottom and front change
           cube.changeTiles(i1,j1,i3,j1);   // bottom and back change
           cube.changeTiles(i3,j1,i4,j2);  // back and top change

           i1++;
           i2++;
           i3++;
           i4--;
       }

       // rotate the side
       cube.changeTiles(3,9,5,9);
       cube.changeTiles(3,11,5,11);
       cube.changeTiles(3,9,5,11);
       cube.changeTiles(3,10,4,9);
       cube.changeTiles(4,11,5,10);
       cube.changeTiles(3,10,5,10);
    }


    public void RPrime(Cube cube){
        int i1 = 3, i2 = 6, i3 = 0, i4 = 5;
        int j1 = 8, j2 = 12;

        for(int i = 0 ; i < 3 ; ++i)
        {
            cube.changeTiles(i1,j1,i3,j1);   // bottom and back change
            cube.changeTiles(i1,j1,i2,j1);   // bottom and front change
            cube.changeTiles(i2,j1,i4,j2);  // front and top change

            i1++;
            i2++;
            i3++;
            i4--;
        }

        // rotate the side
        //rotate edges
        cube.changeTiles(3,9,3,11);
        cube.changeTiles(5,9,5,11);
        cube.changeTiles(3,9,5,11);
        //rotate else
        cube.changeTiles(3,10,4,11);
        cube.changeTiles(5,10,4,9);
        cube.changeTiles(3,10,5,10);
    }

    public void L(Cube cube){
        rotateRight90(cube);
        rotateRight90(cube);
        R(cube);
        rotateRight90(cube);
        rotateRight90(cube);
    }

    public void LPrime(Cube cube) {
        rotateRight90(cube);
        rotateRight90(cube);
        RPrime(cube);
        rotateRight90(cube);
        rotateRight90(cube);
    }

    public void M(Cube cube){
        int i1 = 3, i2 = 6, i3 = 0, i4 = 5;
        int j1 = 7, j2 = 13;

        for(int i = 0 ; i < 3 ; ++i)
        {
            cube.changeTiles(i1,j1,i2,j1);   // bottom and front change
            cube.changeTiles(i1,j1,i3,j1);   // bottom and back change
            cube.changeTiles(i3,j1,i4,j2);  // back and top change

            i1++;
            i2++;
            i3++;
            i4--;
        }

    }

    public void MPrime(Cube cube){
        rotateRight90(cube);
        rotateRight90(cube);
        M(cube);
        rotateRight90(cube);
        rotateRight90(cube);
    }

    public void rotateRight90(Cube cube){

       rotHelp.rotateOnlySidesRight90(cube);

       //rotate bottom

        cube.changeTiles(5,7,4,8);
       cube.changeTiles(3,7,4,6);
       cube.changeTiles(3,7,5,7);

       cube.changeTiles(5,8,3,8);
       cube.changeTiles(3,6,5,6);
       cube.changeTiles(3,6,5,8);
        //rotate top

        cube.changeTiles(3,13,4,14);
        cube.changeTiles(5,13,4,12);
        cube.changeTiles(3,13,5,13);

        cube.changeTiles(3,14,5,14);
        cube.changeTiles(5,12,3,12);
        cube.changeTiles(3,14,5,12);
    }

    public void X(Cube cube){
        R(cube);
        LPrime(cube);
        M(cube);
    }
    public void XPrime(Cube cube){
       X(cube);
       X(cube);
       X(cube);

    }
    public void U(Cube cube){
       X(cube);
       rotateLeft90(cube);
       R(cube);
       rotateRight90(cube);
       XPrime(cube);
    }

    public void rotateLeft90(Cube cube){
        rotateRight90(cube);
        rotateRight90(cube);
        rotateRight90(cube);
    }

    public void UPrime(Cube cube){
        X(cube);
        //System.out.println("X");
        //cube.showCube();

        rotateLeft90(cube);
        //System.out.println("left90");
        //cube.showCube();

        RPrime(cube);
        //System.out.println("Rprime");
       // cube.showCube();

        rotateRight90(cube);
       // System.out.println("right90");
       // cube.showCube();

        XPrime(cube);
        //System.out.println("xPrime");
        //cube.showCube();


    }

    public void F(Cube cube){
       rotateRight90(cube);
       R(cube);
       rotateLeft90(cube);
    }

    public void FPrime(Cube cube){
       rotateLeft90(cube);
       LPrime(cube);
       rotateRight90(cube);
    }

    public void orientColorDown(Cube cube, char color){
       CubeExplorer cubeExp = new CubeExplorer();
       int [] centerCoord = cubeExp.findCenter(cube,color);
       int xCounter = 0;
       int safety = 10;

       while (centerCoord[0] != cube.centerCoordinates[0][0] || centerCoord[1] != cube.centerCoordinates[0][1]){
           if (xCounter < 3){
               X(cube);
               centerCoord = cubeExp.findCenter(cube,color);

           }
           else{
               rotateRight90(cube);
               centerCoord = cubeExp.findCenter(cube,color);
               xCounter = -1;
           }
           if (safety == 0) break;
           safety --;
           ++xCounter;
       }
    }

    public void doFourMoves(Cube cube){
       R(cube);
       U(cube);
       RPrime(cube);
       UPrime(cube);
    }

    public void B(Cube cube){
       X(cube);
       X(cube);
       UPrime(cube);
       X(cube);
       X(cube);
    }


}
