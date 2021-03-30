package garisov.webapp.controllers;

import garisov.webapp.dao.MedicDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    final MedicDAO medicDao;
    public MainController(MedicDAO medicDao) {
        this.medicDao = medicDao;
    }

    @GetMapping()
    public String main(){
        return "main";
    }
    @GetMapping("/{id}")
    public String  show(@PathVariable("id")int id, Model model){
        return "";
    }
}
