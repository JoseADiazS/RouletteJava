package com.josardiaz.modules.roulette.controller;

import com.josardiaz.commons.api.controller.GenericController;
import com.josardiaz.commons.api.controller.RestResponse;
import com.josardiaz.commons.api.service.GenericService;
import com.josardiaz.modules.roulette.domain.Roulette;
import com.josardiaz.modules.roulette.repository.RouletteRepository;
import com.josardiaz.modules.roulette.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roulette")
public class RouletteController extends GenericController<String, Roulette> {

    public RouletteRepository rouletteRepository;
    RouletteService rouletteService;

    public RouletteController(RouletteRepository rouletteRepository) {
        this.rouletteRepository = rouletteRepository;
    }

    @GetMapping("all")
    public List findAll() {
        return rouletteRepository.findAll();
    }


    @PostMapping("save")
    public String createRoulette(@RequestBody Roulette roulette) {
        var roulette1 = rouletteService.save(roulette);
        return roulette1;
    }

    @Override
    protected GenericService<String, Roulette> getService() {
        return rouletteService;
    }

    @GetMapping("opening/{id}")
    @ResponseBody
    ResponseEntity<RestResponse<Roulette>> opening(@PathVariable("id") String id, HttpServletResponse response) {
        Roulette entity = null;
        try {
            entity = rouletteService.opening(id);
        } catch (Exception e) {
            return buildErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return buildResponse("Sucesfully BET", HttpStatus.OK, entity,
                null);
    }
}
