package tn.enis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.enis.entity.Client;
import tn.enis.entity.Compte;
import tn.enis.service.ClientService;
import tn.enis.service.CompteService;

import java.math.BigDecimal;

@Controller
@RequestMapping("/comptes")
@RequiredArgsConstructor
public class CompteController {

    private final CompteService compteService;
    private final ClientService clientService;

    // LIST
    @GetMapping
    public String list(Model model) {
        model.addAttribute("comptes", compteService.findAll());
        return "comptes/list";
    }

    // SHOW ADD FORM
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("compte", new Compte());
        model.addAttribute("clients", clientService.findAll());
        return "comptes/form";
    }

    // SHOW EDIT FORM
    @GetMapping("/edit/{rib}")
    public String showEditForm(@PathVariable Integer rib, Model model) {
        model.addAttribute("compte", compteService.findById(rib));
        model.addAttribute("clients", clientService.findAll());
        return "comptes/form";
    }

    // SAVE (ADD or UPDATE)

    @PostMapping("/save")

    public String save(@RequestParam BigDecimal solde,
                       @RequestParam(required = false) Integer rib,
                       @RequestParam String clientCin) {
        Client client = clientService.findById(clientCin);
        Compte compte = new Compte();
        compte.setRib(rib);
        compte.setSolde(solde);
        compte.setClient(client);
        compteService.save(compte);
        return "redirect:/comptes";

    }

    // DELETE (AJAX)
    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity<Void> delete(@RequestParam Integer rib) {
        compteService.deleteById(rib);
        return ResponseEntity.ok().build();
    }
}