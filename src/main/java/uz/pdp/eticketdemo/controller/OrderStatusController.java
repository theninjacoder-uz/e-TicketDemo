package uz.pdp.eticketdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.dto.OrderStatusDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.OrderStatusService;
import uz.pdp.eticketdemo.service.PassengerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order_status")
public class OrderStatusController {
    private final OrderStatusService service;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody OrderStatusDto orderStatusDto){
        return service.add(orderStatusDto);
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
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody OrderStatusDto orderStatusDto){
        return service.edit(id, orderStatusDto);
    }
}
