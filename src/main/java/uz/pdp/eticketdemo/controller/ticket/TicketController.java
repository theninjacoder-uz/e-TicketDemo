package uz.pdp.eticketdemo.controller.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.ticket.TicketDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.ticket.TicketService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ticket")
public class TicketController {
    private final TicketService service;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody TicketDto ticketDto){
        return service.add(ticketDto);
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
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody TicketDto ticketDto){
        return service.edit(id, ticketDto);
    }
}
