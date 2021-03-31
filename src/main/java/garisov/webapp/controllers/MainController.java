package garisov.webapp.controllers;

import garisov.webapp.dao.MedicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class MainController {

    private final MedicDAO medicDao;
    @Autowired
    public MainController(MedicDAO medicDao) {
        this.medicDao = medicDao;
    }

    @GetMapping()
    public String main(Model model)
    {
        model.addAttribute("medics",medicDao.show());
        return "main";
    }
    @GetMapping("/{id}")
    public String  show(@PathVariable("id")int id, Model model){
        model.addAttribute("medic",medicDao.showId(id));
        return "medic/show";
    }
}
