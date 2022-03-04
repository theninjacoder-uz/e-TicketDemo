package uz.pdp.eticketdemo.controller.schedule;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.schedule.ScheduleDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.schedule.ScheduleService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping
    public ApiResponse getScheduleByRegions(@RequestParam(name = "from_id") Long fId, @RequestParam(name = "to_id") Long tId, @RequestParam(name = "date") String date){
        return null;
    };

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ScheduleDto scheduleDto){
        return ResponseEntity.ok(scheduleService.generateScheduleForTrain(scheduleDto));
    }

}
