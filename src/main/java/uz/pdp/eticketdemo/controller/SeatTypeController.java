package uz.pdp.eticketdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.eticketdemo.dto.SeatTypeDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.SeatTypeService;

@RestController
@RequestMapping("/api/seat_type")
public class SeatTypeController {

    private final SeatTypeService service;

    //Constructor injection better than Field injection (@AutoWired)
    public SeatTypeController(SeatTypeService service) {
        this.service = service;
    }

    //Add
    @PostMapping()
    public ApiResponse add(@RequestBody SeatTypeDto seatTypeDto){
        return service.add(seatTypeDto);
    }
}
