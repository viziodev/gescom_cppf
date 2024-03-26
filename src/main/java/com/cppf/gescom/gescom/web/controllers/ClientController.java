package com.cppf.gescom.gescom.web.controllers;

import com.cppf.gescom.gescom.web.dto.request.ClientCreateDto;
import com.cppf.gescom.gescom.web.dto.response.ClientListeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/clients")
public interface ClientController {
    ///clients?page=1&size=10  ==>  /clients
    @GetMapping("/paginate")
    public ResponseEntity<?> listerClientPaginate (@RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "2")int size );
    @GetMapping("")
    public ResponseEntity<?> listerClient ();
    ///clients/1
     @GetMapping("/{id}")
    public ResponseEntity<?> listerUnClient (@PathVariable Long id);
    @PutMapping("/{id}")
    public ResponseEntity<?> editClient (@PathVariable Long id,@RequestBody ClientCreateDto client);
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient (@PathVariable Long id);
    @PostMapping("")
    public ResponseEntity<?> creerClient (@RequestBody ClientCreateDto client);
}
