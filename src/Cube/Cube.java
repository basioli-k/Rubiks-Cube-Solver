package Cube;

import jdk.internal.util.xml.impl.Pair;

import java.util.Vector;

public class Cube {
    public Vector<String> cubeGrid = new Vector<java.lang.String>();
    protected int [][][] edgeCoordinates = { {{0,7},{3,13}}, {{1,6},{3,4}}, {{1,8},{3,10}}, {{2,7},{3,7}},
            {{4,6},{4,5}}, {{5,7},{6,7}}, {{4,8},{4,9}}, {{4,3},{4,14}}, {{5,4},{7,6}}, {{8,7},{5,13}}, {{7,8},{5,10}},
            {{4,11},{4,12}} };
    protected int [][][] cornerCoordinates = { {{3,5},{3,6},{2,6}}, {{5,5},{5,6},{6,6}}, {{5,8},{5,9},{6,9}}, {{3,8},{3,9},{2,8}},
            {{3,3},{0,6},{3,14}},{{5,3},{8,6},{5,14}}, {{8,8},{5,11},{5,12}},{{3,11},{3,12},{0,8}}
    };

    public int [][] centerCoordinates = {{4,7},{4,4},{4,10},{7,7},{1,7}, {4,13}};
    public Cube(){
        cubeGrid.add("******ooo********");
        cubeGrid.add("******ooo********");
        cubeGrid.add("******ooo********");
        cubeGrid.add("***bbbwwwgggyyy**");
        cubeGrid.add("***bbbwwwgggyyy**");
        cubeGrid.add("***bbbwwwgggyyy**");
        cubeGrid.add("******rrr********");
        cubeGrid.add("******rrr********");
        cubeGrid.add("******rrr********");
    }
    public void changeTiles(int i,int j,int k,int l){
       // System.out.println(i + " " + j + " " + k + " " + l);

        //you need this if statement, otherwise when you make a change to the same row it won't happen
        if(i == k){
            StringBuilder firstTile = new StringBuilder((CharSequence) cubeGrid.get(i));
            char temp = cubeGrid.get(k).charAt(l);
            firstTile.setCharAt(l,cubeGrid.get(i).charAt(j));
            firstTile.setCharAt(j,temp);
            cubeGrid.set(i,firstTile.toString());
        }
        else {
            StringBuilder firstTile = new StringBuilder((CharSequence) cubeGrid.get(i));
            StringBuilder secondTile = new StringBuilder((CharSequence) cubeGrid.get(k));

            char temp = cubeGrid.get(k).charAt(l);

            secondTile.setCharAt(l,cubeGrid.get(i).charAt(j));
            firstTile.setCharAt(j,temp);
            cubeGrid.set(i, firstTile.toString());
            cubeGrid.set(k, secondTile.toString());
        }
    }
    public void showCube(){

        for(int i = 0 ; i < cubeGrid.size(); ++i){
            System.out.println(cubeGrid.get(i));
        }
        System.out.println();
    }


}
