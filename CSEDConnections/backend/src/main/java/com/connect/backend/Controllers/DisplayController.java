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
        if (search != null && !search.isBlank()) {
            Search sh = new Search();
            grads = sh.search(grads, search);
        }
        return convertGrads(grads);
    }

    public Graduate selectGraduate(String email) {
        Data data = new Data('G');
        return data.opengraduate(email);
    }

    private List<DisplayedGrads> convertGrads(List<Graduate> grads) {
        List<DisplayedGrads> displayedgrads = new ArrayList<>();
        for (Graduate g : grads) {
            displayedgrads.add(new DisplayedGrads(g.name, g.mail, g.experience.get(0), g.img));
        }
        return displayedgrads;
    }
}
