/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import ventilationcontrol.VentilationControl;

/**
 *
 * @author wainwetun
 */
public class Environment {
    private IAQ iaq;
    private Effect effect;
    private Fan fan;
    private EnergyConsumption energyConsumption;
    private final float threshold = 150;
    
    public Environment(){}
    
    public Environment(IAQ iaq, Effect effect, Fan fan, EnergyConsumption energyConsumption){
        this.iaq = iaq;
        this.effect = effect;
        this.fan = fan;
        this.energyConsumption = energyConsumption;
    }

    public IAQ getIaq() {
        return iaq;
    }

    public Effect getEffect() {
        return effect;
    }

    public Fan getFan() {
        return fan;
    }

    public EnergyConsumption getEnergyConsumption() {
        return energyConsumption;
    }

    public void setIaq(IAQ iaq) {
        this.iaq = iaq;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public void setEnergyConsumption(EnergyConsumption energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
    
    public void turnOffFan(){
        fan = new Fan(fan.getIdFan());
        fan.setOn(false);
        energyConsumption.setConsumption(0);
        VentilationControl.insertFacts(this);
        VentilationControl.counter = 0;
    }
    
    public void sleep(){
        try{
            //System.err.println("[[ Sleeping ..]]");
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void reduceEnergyConsumption(){
        float frequency = getFrequency()/2;
        fan.setFrequency(frequency);
        
        float duration = getDuration();
        fan.setDuration(duration);
        
        energyConsumption.setConsumption(getEnergyConsumptionValue()/2); 
        VentilationControl.counter = 0;
        VentilationControl.insertFacts(this);
        updateIaqOverTime();
        
    }
    
    public void calculateFanFacts(){
        float frequency = getFrequency();
        fan.setFrequency(frequency);
        //float improve = frequency * effect.getImproved();
        float duration = getDuration();       
        fan.setDuration(duration);
        
        //assume
        energyConsumption.setConsumption(frequency/2); 
        VentilationControl.counter = 0;
        VentilationControl.insertFacts(this);
        updateIaqOverTime();
    }
    
    public void updateIaqOverTime(){
        float newIaq = getNewIAQ();
        iaq.setValue(newIaq);
        iaq.setTime(new Date(iaq.getTime().getTime()+1));
        fan.setDuration(fan.getDuration()-1);
        energyConsumption.setConsumption(getEnergyConsumptionValue());
        VentilationControl.insertFacts(this);
    }
    
    private float getEnergyConsumptionValue(){
        float consumption = energyConsumption.getConsumption() + fan.getFrequency()*0.01f;
        return consumption;
    }
    
    private float getFrequency(){
        return iaq.getValue()-threshold;
    }
    
    private float getDuration(){
        float f = getFrequency();
        return f/effect.getImproved();
    }
    
    private float getNewIAQ(){
        return iaq.getValue()-effect.getImproved();
    }
    
    
    public void display(){
        System.out.println(fan.toString());
        System.out.println(effect.toString());
        System.out.println(energyConsumption.toString());
        System.out.println(iaq.toString());
        System.out.println();
    }
    
}
