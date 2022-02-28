package uz.pdp.eticketdemo.controller.train;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.station.StationDto;
import uz.pdp.eticketdemo.model.dto.train.TrainDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.station.StationService;
import uz.pdp.eticketdemo.service.train.TrainService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/train")
public class TrainController {

    private final TrainService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody TrainDto trainDto){
        return ResponseEntity.ok(service.add(trainDto));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/get")
    public ResponseEntity<?> getById(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestParam(name = "id") Long id, @RequestBody TrainDto trainDto){
        return ResponseEntity.ok(service.edit(id, trainDto));
    }
}
