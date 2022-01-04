package com.connect.backend.Controllers;

import java.util.ArrayList;
import java.util.List;

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
}
