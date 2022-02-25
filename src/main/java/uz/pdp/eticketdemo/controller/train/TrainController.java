package uz.pdp.eticketdemo.controller.train;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    public ApiResponse add(@RequestBody TrainDto trainDto){
        return service.add(trainDto);
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
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody TrainDto trainDto){
        return service.edit(id, trainDto);
    }
}
