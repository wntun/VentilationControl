/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author wainwetun
 */
public class Fan {
    private int idFan;
    private boolean state;
    private float frequency;
    private float duration;
    private float energyConsumption;
    private float percentageImprovement;

    public Fan(){
        this.idFan = 1;
        this.state = false;        
    }
    
    public Fan(int idFan){
        this.idFan = idFan;
        this.state = false;
    }
    
    public void turnOn(float frequency, float duration){
        this.frequency = frequency;
        this.duration = duration;
    }
    
    public void turnOff(){
        this.state = false;
        this.frequency = 0;
        this.duration = 0;
        this.energyConsumption = 0;
        this.percentageImprovement =0;
    }
    
    public int getIdFan() {
        return idFan;
    }

    public boolean isState() {
        return state;
    }

    public float getFrequency() {
        return frequency;
    }

    public float getDuration() {
        return duration;
    }

    public float getEnergyConsumption() {
        return energyConsumption;
    }

    public float getPercentageImprovement() {
        return percentageImprovement;
    }

    public void setIdFan(int idFan) {
        this.idFan = idFan;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public void setEnergyConsumption(float energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public void setPercentageImprovement(float percentageImprovement) {
        this.percentageImprovement = percentageImprovement;
    }
    
    
    
}
