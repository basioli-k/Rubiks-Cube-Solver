package Rotations;

import Cube.Cube;

public class RotationHelp {
    public void rotateOnlySidesRight90(Cube cube)
    {
        int i1=6, i2=5, i3=2, i4=3;
        int j1=6, j2=9, j3=8, j4=5;

        for(int i = 0; i < 3 ; ++i){
            for(int j = 0; j < 3 ; ++j){
                cube.changeTiles(i1,j1,i4,j4);
                cube.changeTiles(i2,j2,i3,j3);
                cube.changeTiles(i2,j2,i4,j4);
                j1++;
                i2--;
                j3--;
                i4++;
            }

            j1=6;
            i2=5;
            j3=8;
            i4=3;
            i1++;
            j2++;
            i3--;
            j4--;
        }
    }
}
