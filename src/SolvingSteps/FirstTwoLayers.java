package SolvingSteps;
import Cube.Cube;
import Cube.CubeExplorer;
import Rotations.Rotation;


public class FirstTwoLayers {
    Rotation rot = new Rotation();
    CubeExplorer cubeExp = new CubeExplorer();


    public void F2L(Cube cube){
        char [][] colorPairs = {{'r','b'},{'o','g'},{'r','g'},{'o','b'}};
        //orijentiraj bijelu dolje
        rot.orientColorDown(cube,'w');
//colorPairs.length
        for(int i = 0 ; i < 4 ; ++i){

            int [][] coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);

            String layer = cubeExp.whichLayer(cube,coloredEdge[0][0],coloredEdge[0][1]);

            while(!layer.equals("top")){
                if(cubeExp.isRightForRotation(cube,coloredEdge[0][0],coloredEdge[0][1])){
                    rot.R(cube);
                    rot.U(cube);
                    rot.RPrime(cube);
                }
                else rot.rotateRight90(cube);
                coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                layer = cubeExp.whichLayer(cube,coloredEdge[0][0],coloredEdge[0][1]);

            }

            int [][] coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');

            layer = cubeExp.whichLayer(cube,coloredCorner[0][0],coloredCorner[0][1]);
            while(!layer.equals("top")){

                if(cubeExp.isRightForRotation(cube,coloredCorner[0][0],coloredCorner[0][1])){
                    while(!((coloredEdge[0][0] == 4 && coloredEdge[0][1] == 14) || (coloredEdge[1][0] == 4 && coloredEdge[1][1] == 14))){
                        rot.U(cube);
                        coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                        coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
                    }
                    rot.R(cube);
                    rot.U(cube);
                    rot.RPrime(cube);

                }
                else rot.rotateRight90(cube);

                coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
                layer = cubeExp.whichLayer(cube,coloredCorner[0][0],coloredCorner[0][1]);

            }

            //postavljamo kut iznad mjesta u kojem treba biti

            while(!cubeExp.cornerPositionedCorrectly(cube,colorPairs[i][0],colorPairs[i][1])){
                rot.U(cube);
            }
            coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
            coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
            //rotiramo tako da kut zdesna

            while(!cubeExp.isRightForRotation(cube, coloredCorner[0][0],coloredCorner[0][1])){

                rot.rotateRight90(cube);
                coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
            }
            //rastavljamo rub i kut po potrebi
            if ((coloredEdge[0][0] ==5 && coloredEdge[0][1] == 13 ) || (coloredEdge[0][0] ==4 && coloredEdge[0][1] == 12 )
                    || (coloredEdge[0][0] == 4 && coloredEdge[0][1] == 11 ) || (coloredEdge[0][0] == 8 && coloredEdge[0][1] == 7 )
            ){
                rot.R(cube);
                rot.U(cube);
                rot.U(cube);
                rot.RPrime(cube);
                rot.UPrime(cube);
            }
            coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
            coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
            //ako je potrebno opet namjestimo kocku kako treba

            while(!cubeExp.cornerPositionedCorrectly(cube,colorPairs[i][0],colorPairs[i][1])){
                rot.U(cube);

            }
            coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
            coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');

            while(!cubeExp.isRightForRotation(cube, coloredCorner[0][0],coloredCorner[0][1])){

                rot.rotateRight90(cube);
                coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');

            }
            //zadnji korak 3 slucaja, tehnicki 6
            coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
            coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
            if(coloredCorner[2][0] == 8 && coloredCorner[2][1] == 8){ //gleda u tebe

                if (coloredCorner[0][0] == 5 && coloredCorner[0][1] == 12){         //gore je r/o
                    if((coloredEdge[0][0] == 4 && coloredEdge[0][1] == 14) || (coloredEdge[0][0] == 3 && coloredEdge[0][1] == 13)){ //podudaraju se boje
                        //.out.println("PRVI SLUCAJ NA ULAZU boje su: " + colorPairs[i][0] + " " + colorPairs[i][1]);
                        //cube.showCube();
                        rot.UPrime(cube);
                        rot.R(cube);
                        coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                        coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
                        while(!(coloredEdge[0][0] == 3 && coloredEdge[0][1] == 13 )){
                            rot.U(cube);
                            coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                            coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');

                        }
                        rot.RPrime(cube);
                        rot.U(cube);
                        rot.U(cube);
                        rot.R(cube);
                        rot.UPrime(cube);
                        rot.RPrime(cube);
                        //System.out.println("PRVI SLUCAJ NA IZLAZU");
                        //cube.showCube();
                    }
                    else{ //drugačije su boje
                       //System.out.println("DRUGI SLUCAJ NA ULAZU boje su: " + colorPairs[i][0] + " " + colorPairs[i][1]);
                        //cube.showCube();
                        if(!(coloredEdge[1][0] == 4 && coloredEdge[1][1] == 14)){
                            rot.UPrime(cube);
                            rot.R(cube);
                            rot.UPrime(cube);
                            rot.RPrime(cube);
                            rot.U(cube);
                        }
                        rot.rotateLeft90(cube);
                        rot.LPrime(cube);
                        rot.UPrime(cube);
                        rot.L(cube);
                        //System.out.println("DRUGI SLUCAJ NA IZLAZU");
                        //cube.showCube();
                    }
                }
                else if (coloredCorner[1][0] == 5 && coloredCorner[1][1] == 12){     //gore je b/g       OVAJ DIO NE RADI
                    if((coloredEdge[1][0] == 4 && coloredEdge[1][1] == 14) || (coloredEdge[1][0] == 3 && coloredEdge[1][1] == 13)){ //podudaraju se boje
                        //System.out.println("TRECI SLUCAJ NA ULAZU boje su: " + colorPairs[i][0] + " " + colorPairs[i][1]);
                        //cube.showCube();
                        rot.UPrime(cube);
                        rot.R(cube);
                        coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                        coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');

                        while(!(coloredEdge[1][0] == 3 && coloredEdge[1][1] == 13 )){
                            rot.U(cube);
                            coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                            coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');

                        }
                        rot.RPrime(cube);
                        rot.U(cube);
                        rot.U(cube);
                        rot.R(cube);
                        rot.UPrime(cube);
                        rot.RPrime(cube);
                        //System.out.println("TRECI SLUCAJ NA IZLAZU");
                        //cube.showCube();

                    }
                    else{ //drugačije su boje      // tu nešto zeza
                        //System.out.println("CETVRTI SLUCAJ NA ULAZU boje su: \" + colorPairs[i][0] + \" \" + colorPairs[i][1]");
                       // cube.showCube();
                        if(!(coloredEdge[0][0] == 4 && coloredEdge[0][1] == 14)){
                            rot.UPrime(cube);
                            rot.R(cube);
                            rot.UPrime(cube);
                            rot.RPrime(cube);
                            rot.U(cube);
                        }
                        rot.rotateLeft90(cube);
                        rot.LPrime(cube);
                        rot.UPrime(cube);
                        rot.L(cube);
                       // System.out.println("CETVRTI SLUCAJ NA IZLAZU");
                        //cube.showCube();
                    }
                }
            }
            else if (coloredCorner[2][0] == 5 && coloredCorner[2][1] == 11){   //sa strane je bijela
                if(cubeExp.sameColorUp(cube,coloredEdge,coloredCorner)){ //gore se nalazi ista boja

                   // if((cube.cubeGrid.get(3).charAt(13) == colorPairs[i][0] && cube.cubeGrid.get(0).charAt(7) == colorPairs[i][1] ) ||
                      //      cube.cubeGrid.get(4).charAt(14) == colorPairs[i][0] && cube.cubeGrid.get(4).charAt(3) == colorPairs[i][1]){
                       //System.out.println("5 slucaj na ulazu boje su: " + colorPairs[i][0] + " " + colorPairs[i][1]);
                        //cube.showCube();
                        rot.U(cube);
                        rot.FPrime(cube);
                        coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                        coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
                        while(!((coloredEdge[1][0] == 4 && coloredEdge[1][1] == 14) || (coloredEdge[0][0] == 4 && coloredEdge[0][1] == 14))){     //(coloredEdge[1][0] == 4 && coloredEdge[1][1] == 14) || ovo je vjv greska
                            rot.U(cube);
                            coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                            coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
                        }

                        rot.F(cube);
                        rot.UPrime(cube);
                        rot.UPrime(cube);
                        rot.FPrime(cube);
                        rot.U(cube);
                        rot.F(cube);
                   // System.out.println("5 slucaj izlaz");
                   // cube.showCube();

                }
                else{  //razlicite boje gore
                  //  System.out.println("6 slučaj na ulazu boje su: " + colorPairs[i][0] + " " + colorPairs[i][1]);
                    //cube.showCube();
                    if(!((coloredEdge[0][0]== 0 && coloredEdge[0][1]== 7) || (coloredEdge[1][0] ==0 && coloredEdge[1][1] ==7))){    // (coloredEdge[0][0]== 3 && coloredEdge[0][1]==13) ||  ovo ne bi trebalo biti moguće
                        rot.UPrime(cube);
                        rot.R(cube);
                        rot.U(cube);
                        rot.RPrime(cube);
                        rot.U(cube);
                       // System.out.println("trebalo");     // ovo radi (kad treba)s
                    }
                   // else System.out.println("nije trebalo");
                    rot.R(cube);
                    rot.U(cube);
                    rot.RPrime(cube);
                  // System.out.println("6. slučaj na izlazu");
                    //cube.showCube();
                }
            }
            else if (coloredCorner[2][0] == 5 && coloredCorner[2][1] == 12){   //bijela je gore
               // System.out.println("7 slucaj na ulazu boje su: " + colorPairs[i][0] + " " + colorPairs[i][1]);
               // cube.showCube();
                int value = cubeExp.edgeIsCorrect(cube,coloredEdge);
                while(!(value > 0 )){
                    rot.U(cube);
                    coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                    coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
                    value = cubeExp.edgeIsCorrect(cube,coloredEdge);
                }
                if (value == 1) {           //gleda tebe
                    //.out.println("7.1");
                   // cube.showCube();
                    rot.FPrime(cube);

                    while(!cubeExp.cornerAboveEdge(cube,coloredCorner,coloredEdge)){

                        rot.U(cube);
                        coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                        coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
                    }
                    rot.F(cube);
                    rot.UPrime(cube);
                    rot.FPrime(cube);
                    rot.U(cube);
                    rot.F(cube);
                  //  System.out.println("7.1 na izlazu");
                   // cube.showCube();
                }
                else if (value == 2) {
                   // System.out.println("7.2");
                  //  cube.showCube();
                    rot.R(cube);
                    coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                    coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');
                    while(!cubeExp.cornerAboveEdge(cube,coloredCorner,coloredEdge)){
                        rot.U(cube);
                        coloredEdge = cubeExp.findEdge(cube,colorPairs[i][0],colorPairs[i][1]);
                        coloredCorner = cubeExp.findCorner(cube,colorPairs[i][0],colorPairs[i][1],'w');

                    }
                    //System.out.println("NAKON PETLJE");
                   // cube.showCube();
                    rot.RPrime(cube);
                    rot.U(cube);
                    rot.R(cube);
                    rot.UPrime(cube);
                    rot.RPrime(cube);
                  //  System.out.println("7.2 na izlazu");
                  //  cube.showCube();
                }
            }
        }

        System.out.println("End of F2L");

    }
}
