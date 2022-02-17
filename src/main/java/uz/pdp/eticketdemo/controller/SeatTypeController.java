package uz.pdp.eticketdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.dto.SeatTypeDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.SeatTypeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seat_type")
public class SeatTypeController {

    private final SeatTypeService service;

//    public SeatTypeController(SeatTypeService service) {
//        this.service = service;
//    }

    //Constructor injection better than Field injection (@AutoWired)
//    @Autowired
//    public SeatTypeController(SeatTypeService service) {
//        this.service = service;
//    }

    //Add
    @PostMapping("/add")
    public ApiResponse add(@RequestBody SeatTypeDto seatTypeDto){
        return service.add(seatTypeDto);
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
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody SeatTypeDto seatTypeDto){
        return service.edit(id, seatTypeDto);
    }
}
