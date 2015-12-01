/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilationcontrol;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.Effect;
import model.EnergyConsumption;
import model.Environment;
import model.Fan;
import model.IAQ;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.conf.EventProcessingOption;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.KnowledgeSessionConfiguration;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.conf.ClockTypeOption;
import org.drools.runtime.rule.FactHandle;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;
import org.drools.time.SessionPseudoClock;

/**
 *
 * @author wainwetun
 */
public class VentilationControl {
    private static KnowledgeBase kbase;
    private static StatefulKnowledgeSession ksession;
    private static WorkingMemoryEntryPoint entrypoint;
    private static FactHandle factHandle;
    public static int counter;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        counter = 0;
        initDrools();
        //insertFacts();
    }
    
    private static void initDrools(){
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Collection<KnowledgePackage> pkgs;
        
        KnowledgeBaseConfiguration config = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
        config.setOption(EventProcessingOption.STREAM);
        
        KnowledgeSessionConfiguration sessionConfig = KnowledgeBaseFactory.newKnowledgeSessionConfiguration();
        sessionConfig.setOption(ClockTypeOption.get("pseudo"));

        kbase = KnowledgeBaseFactory.newKnowledgeBase(config);
        kbuilder.add( ResourceFactory.newClassPathResource( "ventilationcontrol//SampleRule.drl",VentilationControl.class),ResourceType.DRL);
 
        if ( kbuilder.hasErrors() ) {
            System.out.println( kbuilder.getErrors().toString() );
            throw new RuntimeException( "Unable to compile drl\"." );
        }
        pkgs = kbuilder.getKnowledgePackages(); 
        kbase.addKnowledgePackages( pkgs );
        
        ksession = kbase.newStatefulKnowledgeSession(sessionConfig,null);
        entrypoint = ksession.getWorkingMemoryEntryPoint("entrypoint");
        
        new Thread(){
            public void run(){
                //ksession.fireUntilHalt();
            }
        }.start();
        
        IAQ iaq1 = new IAQ(1, 200, new Date());
        EnergyConsumption ec = new EnergyConsumption(0);
        Environment environment = new Environment(iaq1, new Effect(10f), 
                new Fan(), ec);
        insertFacts(environment);
        //factHandle = ksession.insert(environment);
        //ksession.insert(environment);
        //System.out.println("inserted");
        
//        try{
//            System.err.println("[[ Sleeping ..]]");
//            Thread.sleep(50000);
//        }
//        catch(InterruptedException ex){
//            System.err.println(ex.getMessage());
//        }
//        System.err.println("[[ Awake .. ]]");
        
        //ksession.halt();
        //ksession.dispose();
        //System.out.println("halted");
        
    }
    
    public static void insertFacts(Environment environment){
        SessionPseudoClock clock = ksession.getSessionClock();      
        //System.out.println(environment.getEnergyConsumption().toString());
        counter = counter + 1;
        clock.advanceTime(counter, TimeUnit.MINUTES);
        //System.out.println("Before Insertion ..");
        //environment.display();
        if(factHandle == null){
            factHandle = entrypoint.insert(environment);
            //System.out.println("inserted");
        }
        else{
            entrypoint.update(factHandle, environment);
            //System.out.println("updated");
        }
        
        
        
        //System.err.println("[[ Awake .. ]]");
        //System.out.println("inserted");
        ksession.fireAllRules();
        
        
        //ksession.halt();
        //ksession.dispose();
        
    }
}
