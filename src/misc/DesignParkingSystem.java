package misc;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=1603,
title = " Design Parking System",
url = "https://leetcode.com/problems/design-parking-system/",
level = Level.EASY)
public class DesignParkingSystem {

}
class ParkingSystem {
    private int big;
    private int medium;
    private int small;


    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;


    }

    public boolean addCar(int carType) {
        boolean added=false;
        switch(carType){
            case 1:
                if(big>0){
                    big-=1;
                    added=true;
                }
                break;
            case 2:
                if(medium>0){
                    medium-=1;
                    added=true;
                }
                break;
            case  3:
                if(small>0){
                    small-=1;
                    added=true;
                }
                break;

        }


        return added;
    }
}
