package uz.pdp.eticketdemo.controller.schedule;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.eticketdemo.response.ApiResponse;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @GetMapping
    public ApiResponse getScheduleByRegions(@RequestParam(name = "from_id") Long fId, @RequestParam(name = "to_id") Long tId, @RequestParam(name = "date") String date){
        return null;
    };

}
