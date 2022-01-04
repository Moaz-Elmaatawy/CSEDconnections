package com.connect.backend.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class DisplayController {
    public List<DisplayedGrads> Display(String search) {
        Data data = new Data('G');
        List<Graduate> grads = data.startdisplay();
        if (search != null && search.isBlank()) {
            // Search sh = new Search();
            // grads = sh.search(grads, search);
        }
        return convertGrads(grads);
    }
    public List<Graduate> graduatecontroller(String email) {
        Data data = new Data('G');
        List<Graduate> grad = data.opengraduate(email);
        
        return grad;
    }

    private List<DisplayedGrads> convertGrads(List<Graduate> grads) {
        List<DisplayedGrads> displayedgrads = new ArrayList<>();
        for (Graduate g : grads) {
            displayedgrads.add(new DisplayedGrads(g.name, g.mail, g.experience.get(0), g.img));
        }
        return displayedgrads;
    }
    Graduate ReqGraduate ;
    @CrossOrigin("*")
    @GetMapping("/opengraduate")
    public String opengraduate(@RequestParam(value = "email") String email ) {
        DisplayController controller = new DisplayController();
        List<Graduate> graduate = controller.graduatecontroller(email) ;
        ReqGraduate = graduate.get(0) ;
       return "done" ;
    }

    @CrossOrigin("*")
    @PostMapping("/get_graduate_details")
    public String GetGraduateDetails(@RequestBody String info) {
        

        // System.out.println(tuple.getString("email"));
        Gson gson = new Gson();
        // Type listType = new TypeToken<List<DisplayedGrads>>() {
        // }.getType();
        java.lang.reflect.Type type = new TypeToken<Graduate>() {
        }.getType();
        String json = gson.toJson(ReqGraduate, type);
        return json;

    }

}
