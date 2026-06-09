package tn.enis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.enis.entity.Client;
import tn.enis.service.ClientService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    // LIST
    @GetMapping
    public String list(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "clients/list";
    }

    // SHOW ADD FORM
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "clients/form";
    }

    // SHOW EDIT FORM
    @GetMapping("/edit/{cin}")
    public String showEditForm(@PathVariable String cin, Model model) {
        model.addAttribute("client", clientService.findById(cin));
        return "clients/form";
    }

    // SAVE (ADD or UPDATE)
    @PostMapping("/save")
    public String save(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    // DELETE (AJAX)
    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity<Void> delete(@RequestParam String cin) {
        clientService.deleteById(cin);
        return ResponseEntity.ok().build();
    }

    // AUTOCOMPLETE (JSON)
    @GetMapping("/autocomplete")
    @ResponseBody
    public List<Map<String, String>> autocomplete(@RequestParam String term) {
        return clientService.search(term).stream()
                .map(c -> Map.of(
                        "id",    c.getCin(),
                        "label", c.getNom() + " " + c.getPrenom() + " (" + c.getCin() + ")",
                        "value", c.getNom() + " " + c.getPrenom()
                ))
                .collect(Collectors.toList());
    }
}