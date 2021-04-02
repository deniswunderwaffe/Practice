package garisov.webapp.controllers;

import garisov.webapp.dao.ClientDAO;
import garisov.webapp.dao.MedicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MedicDAO medicDao;
    private final ClientDAO clientDao;
    @Autowired
    public AdminController(MedicDAO medicDao, ClientDAO clientDao) {
        this.medicDao = medicDao;
        this.clientDao = clientDao;
    }
    @GetMapping()
    public String admin_main(Model model)
    {
        model.addAttribute("orders",clientDao.show());
        return "admin/main";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        clientDao.delete(id);
        return "redirect:/admin";
    }
}
