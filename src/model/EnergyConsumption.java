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
public class EnergyConsumption {
    private float consumption;

    @Override
    public String toString() {
        return "EnergyConsumption{" + "consumption=" + consumption + '}';
    }

    public void setConsumption(float frequency) {
        this.consumption = frequency;
    }

    public float getConsumption() {
        return consumption;
    }
    
    public EnergyConsumption(float frequency){
        consumption = frequency;
    }
    
    private float calculateConsumption(float frequency){
        return frequency* 10f;
    }
}
