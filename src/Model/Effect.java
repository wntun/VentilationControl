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
public class Effect {
    private int idEffect;
    private float percentage;
    private Fan fan;
    private IAQ iaq;

    public int getIdEffect() {
        return idEffect;
    }

    public float getPercentage() {
        return percentage;
    }

    public Fan getFan() {
        return fan;
    }

    public IAQ getIaq() {
        return iaq;
    }

    public void setIdEffect(int idEffect) {
        this.idEffect = idEffect;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public void setIaq(IAQ iaq) {
        this.iaq = iaq;
    }
    
    
    
    
}
