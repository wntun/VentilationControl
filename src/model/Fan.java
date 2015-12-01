/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author wainwetun
 */
public class Fan {
    private int idFan;
    private boolean on;
    private float frequency;
    private float duration;


    public Fan(){
        this.idFan = 1;
        this.on = false;        
    }
    
    public Fan(int idFan){
        this.idFan = idFan;
        this.on = false;
    }
    
    public void turnOn(float frequency, float duration){
        this.frequency = frequency;
        this.duration = duration;
    }
    
    public void turnOff(){
        this.on = false;
        this.frequency = 0;
        this.duration = 0;
    }
    
    public int getIdFan() {
        return idFan;
    }

    public boolean isOn() {
        return on;
    }

    public float getFrequency() {
        return frequency;
    }

    public float getDuration() {
        return duration;
    }


    public void setIdFan(int idFan) {
        this.idFan = idFan;
    }

    public void setOn(boolean state) {
        this.on = state;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "Fan{" + "idFan=" + idFan + ", on=" + on + ", frequency=" + frequency + ", duration=" + duration + ", energyConsumption=" + '}';
    }
    
    
    
}
