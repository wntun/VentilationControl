/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author wainwetun
 */
public class IAQ {
    private int idIAQ;
    private float value;
    private Date time;

    public int getIdIAQ() {
        return idIAQ;
    }

    public float getValue() {
        return value;
    }

    public Date getTime() {
        return time;
    }

    public void setIdIAQ(int idIAQ) {
        this.idIAQ = idIAQ;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    
    
}
