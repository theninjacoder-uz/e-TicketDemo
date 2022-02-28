package uz.pdp.eticketdemo.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.user.PassengerDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.user.PassengerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passenger")
public class PassengerController {
    private final PassengerService service;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody PassengerDto passengerDto,
                           @RequestParam(name = "id") Long userId){
        return service.add(userId, passengerDto);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(service.getList());
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
