package com.connect.backend.Controllers;

import java.util.ArrayList;
import java.util.List;

public class Search {
    List<Graduate> search(List<Graduate> g ,String s){

        List<Graduate> result=  new ArrayList<>();

        for(int i=0;i<g.size();++i){
            if(match(g.get(i),s)){
                result.add(g.get(i));
            }

        }
        return result;
    }
    boolean match(Graduate grad ,String s){
        String keyWords []=s.split(" ");
        
        // search in the "about" field
        for(String word : keyWords){
            if(grad.about.matches("(.*)"+word+"(.*)"))
                return true;
        } 
        
        // search in the "name" field
        for(String word : keyWords){
            if(grad.name.matches("(.*)"+word+"(.*)"))
                return true;
        } 

        // search in the "graduationYear" field
        for(String word : keyWords){
            if(grad.graduationYear.matches("(.*)"+word+"(.*)"))
                return true;
        }
        
        // search in the "Experience" field
        for(String word : keyWords){
            for(int i=0;i<grad.experience.size();++i){
                if(grad.experience.get(i).companyName.matches("(.*)"+word+"(.*)"))
                    return true;
                if(grad.experience.get(i).location.matches("(.*)"+word+"(.*)"))
                    return true;
                if(grad.experience.get(i).position.matches("(.*)"+word+"(.*)"))
                    return true;
            }
        } 

        return false;
    }
}
