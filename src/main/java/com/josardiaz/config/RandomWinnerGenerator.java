package com.josardiaz.config;

import com.josardiaz.enums.ColorsEnum;

public class RandomWinnerGenerator {

    public RandomWinnerGenerator(){}

    public static ColorsEnum generateColor(){
        ColorsEnum[] colors = ColorsEnum.values();
        int max = (colors.length -1);
        int min = 0;
        int varX = (int) ((Math.random() * ((max-min)+1))+min);
        return colors[varX];
    }

    public static int RandomNum(){
        int max = 36;
        int min = 0;
        return (int) ((Math.random()*((max - min)+1) + min));
    }
}
