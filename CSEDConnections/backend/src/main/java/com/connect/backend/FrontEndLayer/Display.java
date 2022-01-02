package com.connect.backend.FrontEndLayer;

import java.util.List;

import com.connect.backend.Controllers.DisplayController;
import com.connect.backend.Controllers.DisplayedGrads;
import com.connect.backend.DatabaseLayer.Database;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Display {

    @CrossOrigin("*")
    @PostMapping("/get_graduates")
    public String showgraduates(@RequestBody String contact) {
        DisplayController controller = new DisplayController();
        List<DisplayedGrads> grads = controller.Display(null);

        // System.out.println(tuple.getString("email"));
        Gson gson = new Gson();
        // Type listType = new TypeToken<List<DisplayedGrads>>() {
        // }.getType();
        java.lang.reflect.Type listType = new TypeToken<List<DisplayedGrads>>() {
        }.getType();
        String json = gson.toJson(grads, listType);
        return json;

    }
}
