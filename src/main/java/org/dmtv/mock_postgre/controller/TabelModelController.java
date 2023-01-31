package org.dmtv.mock_postgre.controller;

import org.dmtv.mock_postgre.model.TabelModel;
import org.dmtv.mock_postgre.repository.TabelModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;


@RestController
@RequestMapping("/")
public class TabelModelController {

    @Autowired
    TabelModelRepository tabelModelRepository;

    @GetMapping("/{login}")
    public ResponseEntity<TabelModel> getInfoByLogin(@PathVariable(value = "login") String login) {
        TabelModel tb = tabelModelRepository.selectByLogin(login);

        if (tb != null) {
            return new ResponseEntity<>(tb, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/")
    public ResponseEntity<String> insertInfo(@RequestBody TabelModel tb) {
        try {
            tabelModelRepository.insertTabelInfo(new TabelModel(tb.getLogin(), tb.getPassword(), tb.getDate(), tb.getEmail()));
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
