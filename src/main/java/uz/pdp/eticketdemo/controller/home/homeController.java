package uz.pdp.eticketdemo.controller.home;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.schedule.ScheduleSearchDto;

@RestController
@RequestMapping("/home")
public class homeController {


    @GetMapping
    public ResponseEntity<?> findSchedule(@RequestBody ScheduleSearchDto searchDto){
        return null;
        //TODO implement method body;
    }

}
