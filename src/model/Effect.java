/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author wainwetun
 */
public class Effect {
    private float improved;

    public Effect(float improved){
        this.improved = improved;
    }
    public float getImproved() {
        return improved;
    }

    @Override
    public String toString() {
        return "Effect{" + "improved=" + improved + '}';
    }

    public void setImproved(float improved) {
        this.improved = improved;
    }
    
    
//    public static void calculateEffect(Fan fan, IAQ iaq){
//        float frequency = fan.getFrequency();
//        float duration = fan.getDuration();
//        float currentIAQ = iaq.getValue();
//        
//        float improved = (frequency*duration)*0.2f;
//        
//        float reducedIAQ = currentIAQ-currentIAQ*improved;
//        
//        Date now = new Date();
//        /*
//        Date[] newTime = new Date[(int)duration];
//        
//        for(int i=0;i<duration; i++){
//            newTime[i] = new Date(now.getTime()+i+1);
//        }    
//                */
//    }
    
}
