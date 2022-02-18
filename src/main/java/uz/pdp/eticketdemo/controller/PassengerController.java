package uz.pdp.eticketdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.PassengerDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.PassengerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passenger")
public class PassengerController {
    private final PassengerService service;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody PassengerDto passengerDto){
        return service.add(passengerDto);
    }

    @GetMapping("/list")
    public ApiResponse getList(){
        return service.getList();
    }

    @GetMapping("/get")
    public ApiResponse getById(@RequestParam(name = "id") Long id){
        return service.getById(id);
    }

    @PostMapping("/edit")
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody PassengerDto passengerDto){
        return service.edit(id, passengerDto);
    }

}
