package uz.pdp.eticketdemo.controller.address;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.address.RegionDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.address.RegionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/region")
public class RegionController {
    private final RegionService service;
    @PostMapping("/add")
    public ApiResponse add(@RequestBody RegionDto regionDto){
        return service.add(regionDto);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        ApiResponse list = service.getList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get")
    public ApiResponse getById(@RequestParam(name = "id") Long id){
        return service.getById(id);
    }

    @PostMapping("/edit")
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody RegionDto regionDto){
        return service.edit(id, regionDto);
    }
}
