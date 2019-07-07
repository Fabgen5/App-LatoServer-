package it.univaq.disim.mobile.myunivaq.api;


import it.univaq.disim.mobile.myunivaq.domain.Negozio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.mobile.myunivaq.business.MyUnivaqService;

@RestController
@RequestMapping("/api/negozio")
public class RESTNegozioController {

    @Autowired
    private MyUnivaqService service;

    @GetMapping("/{id}")
    public Negozio findById(@PathVariable Long id) {
        return service.findNegozioById(id);
    }

}
