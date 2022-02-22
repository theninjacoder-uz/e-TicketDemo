package uz.pdp.eticketdemo.controller.direction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.direction.DirectionDto;
import uz.pdp.eticketdemo.model.dto.direction.DirectionStationDto;
import uz.pdp.eticketdemo.service.direction.DirectionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/direction")
public class DirectionController {

    private final DirectionService directionService;

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody DirectionDto directionDto){
        return ResponseEntity.status(HttpStatus.OK).body(directionService.add(directionDto));
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestParam(name = "id") Long id, @RequestBody DirectionDto directionDto){
        return ResponseEntity.status(HttpStatus.OK).body(directionService.edit(id, directionDto));
    }

    @DeleteMapping("/delete")
    public HttpEntity<?> delete(@RequestParam(name = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(directionService.delete(id));
    }

    @GetMapping("/get")
    public HttpEntity<?> getById(@RequestParam(name = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(directionService.getById(id));
    }

    @GetMapping("/list")
    public HttpEntity<?> getList(){
        return ResponseEntity.status(HttpStatus.OK).body(directionService.getList());
    }
}
