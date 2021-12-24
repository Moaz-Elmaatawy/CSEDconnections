package com.connect.backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.subst.Token.Type;

@RestController
public class displayGraduatesController {
    Database database = new Database() ;
    @CrossOrigin("*")
    @PostMapping("/get_graduates")
    public String showgraduates(@RequestBody String contact)   {
        
        List<ResultSet> grads = database.getGraduates() ;
        List<DisplayedGrads> displayedGrads = new ArrayList<>();
        for(ResultSet set : grads){
            DisplayedGrads gradtemp = new DisplayedGrads();
            try {
                gradtemp.company = set.getString("company") ;
                gradtemp.email = set.getString("email") ;
                gradtemp.img = set.getString("imageURL") ;
                gradtemp.location = set.getString("location") ;
                gradtemp.name = set.getString("name") ;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           

            displayedGrads.add(gradtemp) ;

        } 
         //System.out.println(tuple.getString("email"));  
        Gson gson = new Gson();     
       // Type listType = new TypeToken<List<DisplayedGrads>>() {
      //  }.getType(); 
       java.lang.reflect.Type listType = new TypeToken<List<DisplayedGrads>>(){}.getType() ;
        String json = gson.toJson(grads,listType);
        return "good" ;

    }
}
