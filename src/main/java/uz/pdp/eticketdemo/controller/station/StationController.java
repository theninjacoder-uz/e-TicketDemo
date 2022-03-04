package uz.pdp.eticketdemo.controller.station;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.station.StationDto;
import uz.pdp.eticketdemo.model.dto.station.StationReceiveDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.station.StationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/station")
public class StationController {
    private final StationService service;
    @PostMapping("/add")
    public ApiResponse add(@RequestBody StationReceiveDto stationDto){
        return service.add(stationDto);
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
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody StationReceiveDto stationDto){
        return service.edit(id, stationDto);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
