package com.connect.backend.Controllers;

import java.util.ArrayList;
import java.util.List;

public class Search {
    List<post> searchPosts(List<post> p ,String s){

        List<post> result=  new ArrayList<>();

        for(int i=0;i<p.size();++i){
            if(match(p.get(i).toString(),s)){
                result.add(p.get(i));
            }

        }
        return result;
    }
    List<Graduate> searchGraduates(List<Graduate> g ,String s){

        List<Graduate> result=  new ArrayList<>();

        for(int i=0;i<g.size();++i){
            if(match(g.get(i).toString(),s) ){
                result.add(g.get(i));
            }

        }
        return result;
    }

    boolean match(String text ,String s){
        
        String keyWords []=s.split(" ");
        
        // search in the text for s
        for(String word : keyWords){
            if(text.matches("(.*)"+word+"(.*)"))
                return true;
        } 
        
        return false;
    }
}
