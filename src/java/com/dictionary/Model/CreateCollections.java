/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.dictionary.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Denis
 */
@Stateless
public class CreateCollections implements CreateCollectionsLocal {

    @Override
    public Collection<Meanings> MeaningCollection(String meanings) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<PartsOfSpeach> POFCollection(Collection<String> pof, Words wId, List<BigDecimal> pofId) {
        Collection<PartsOfSpeach> result = new ArrayList<>();
        int i = 0;
        for(String p : pof){
            PartsOfSpeach partsOfSpeach = new PartsOfSpeach();
            partsOfSpeach.setPof(p);
            partsOfSpeach.setWId(wId);
            if (pofId != null){
                partsOfSpeach.setPofId(pofId.get(i));
                i++;
            }
            result.add(partsOfSpeach);
        }
        
        return result;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<String> SpeechCollection(String speech) {
        String[] split = speech.split(";");
        Collection<String> result = Arrays.asList(split);
        
        return result;
    }

    @Override
    public List<Collection<String>> MeanList(String meanString) {
        List<Collection<String>> result = new ArrayList<>();
        Collection<String> mean = new ArrayList<>();
        String[] lines = meanString.split("\n");
        
        List<String[]> splitLine = new ArrayList<>();
        for(String l : lines){
            splitLine.add(l.split("\\."));
        }
        
        int iter = -1;
        int counter = 0;
        for(String[] sl : splitLine){
            if (counter == 0){
                iter = Integer.parseInt(sl[0]);
                mean.add(sl[1]);
            }else{
                if(iter == Integer.parseInt(sl[0])){
                    mean.add(sl[1]);
                }else{
                    iter = Integer.parseInt(sl[0]);
                    result.add(mean);
                    mean = new ArrayList<>();
                    mean.add(sl[1]);
                }
            }
            
            counter++;
        }
        result.add(mean);
        
//        int count = 1;
//        for(Collection<String> r : result){
//            for(String sr : r)
//                System.out.print(count + ":" + sr);
//            
//            count++;
//        }
        // Make mistake check
        return result;
    }
}
