package uz.pdp.eticketdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.dto.SeatTypeDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.SeatTypeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seat_type")
public class SeatTypeController {

    private final SeatTypeService service;

    //Add
    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody SeatTypeDto seatTypeDto){
        return ResponseEntity.status(HttpStatus.OK).body(service.add(seatTypeDto));
    }

    @GetMapping("/list")
    public HttpEntity<?> getList(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getList());
    }

    @GetMapping("/get")
    public HttpEntity<?> getById(@RequestParam(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PostMapping("/edit")
    public HttpEntity<?> edit(@RequestParam(name = "id") Long id, @RequestBody SeatTypeDto seatTypeDto){
        return ResponseEntity.status(HttpStatus.OK).body(service.edit(id, seatTypeDto));

    }
}
