package uz.pdp.eticketdemo.controller.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.eticketdemo.model.dto.schedule.ScheduleSearchDto;
import uz.pdp.eticketdemo.service.schedule.ScheduleService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")
public class BookingController {
    private final ScheduleService scheduleService;

    @PostMapping("/search")
    public ResponseEntity<?> searchTrain(@RequestBody ScheduleSearchDto scheduleSearchDto) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAvailableTrainMap(scheduleSearchDto));
    }
}
