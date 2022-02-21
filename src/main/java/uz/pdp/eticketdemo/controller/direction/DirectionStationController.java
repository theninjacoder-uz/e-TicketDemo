package uz.pdp.eticketdemo.controller.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.direction.DirectionStationDto;
import uz.pdp.eticketdemo.service.direction.DirectionStationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/direction-station")
public class DirectionStationController {

    private final DirectionStationService directionStationService;

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody DirectionStationDto directionStationDto){
        return ResponseEntity.status(HttpStatus.OK).body(directionStationService.add(directionStationDto));
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestParam(name = "id") Long id, @RequestBody DirectionStationDto directionStationDto){
        return ResponseEntity.status(HttpStatus.OK).body(directionStationService.edit(id, directionStationDto));
    }

    @DeleteMapping("/delete")
    public HttpEntity<?> delete(@RequestParam(name = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(directionStationService.delete(id));
    }

    @GetMapping("/get")
    public HttpEntity<?> getById(@RequestParam(name = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(directionStationService.getById(id));
    }

    @GetMapping("/list")
    public HttpEntity<?> getList(){
        return ResponseEntity.status(HttpStatus.OK).body(directionStationService.getList());
    }

}
