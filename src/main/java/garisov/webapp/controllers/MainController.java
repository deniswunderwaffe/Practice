package garisov.webapp.controllers;

import garisov.webapp.clients.Client;
import garisov.webapp.dao.ClientDAO;
import garisov.webapp.dao.MedicDAO;
import garisov.webapp.medics.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/main")
public class MainController {

    private final MedicDAO medicDao;
    private final ClientDAO clientDao;
    @Autowired
    public MainController(MedicDAO medicDao, ClientDAO clientDao) {
        this.medicDao = medicDao;
        this.clientDao = clientDao;
    }

    @GetMapping()
    public String main(Model model)
    {
        model.addAttribute("medics",medicDao.show());
        return "main/main";
    }
    @GetMapping("/{id}")
    public String  show(@PathVariable("id")int id, Model model){
        model.addAttribute("medic",medicDao.showId(id));
        return "medic/show";
    }
    @GetMapping("/new")
    public String newClient(@ModelAttribute("client")Client client){
        return "main/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("client") @Valid Client client,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "main/new";

        clientDao.save(client);
        return "redirect:/main";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id")int id){
        model.addAttribute("medic",medicDao.showId(id));
        return "medic/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("medic")Medic medic,
                         @PathVariable("id")int id){
        medicDao.update(id,medic);
        return "redirect:/main";
    }

}
