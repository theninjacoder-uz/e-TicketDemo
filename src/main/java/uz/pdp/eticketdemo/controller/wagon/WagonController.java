package uz.pdp.eticketdemo.controller.wagon;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.wagon.WagonDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.wagon.WagonService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wagon")
public class WagonController {
    private final WagonService service;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody WagonDto wagonDto){
        return service.add(wagonDto);
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
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody WagonDto wagonDto){
        return service.edit(id, wagonDto);
    }
}
