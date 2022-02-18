package uz.pdp.eticketdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.PassengerDto;
import uz.pdp.eticketdemo.model.dto.TicketDto;
import uz.pdp.eticketdemo.model.entity.PassengerEntity;
import uz.pdp.eticketdemo.model.entity.TicketEntity;
import uz.pdp.eticketdemo.repository.TicketRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService extends BaseResponse implements BaseService<TicketDto>{
    private final TicketRepository ticketRepository;

    @Override
    public ApiResponse getList() {
        List<TicketEntity> list = ticketRepository.findAll();
        SUCCESS.setData(list);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<TicketEntity> optional = ticketRepository.findById(id);

        if(optional.isPresent()){
            SUCCESS.setData(optional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = ticketRepository.existsById(id);
        if(exists) {
            ticketRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, TicketDto item) {
        Optional<TicketEntity> optional = ticketRepository.findById(id);

        if(optional.isPresent()){
            TicketEntity ticket = optional.get();
            ticket.setPassenger(item.getPassenger());
            ticket.setTrain(item.getTrain());
            ticket.setFromStation(item.getFromStation());
            ticket.setToStation(item.getToStation());
            ticket.setDate(item.getDate());
            ticket.setWagon(item.getWagon());
            ticket.setSeat(item.getSeat());
            ticket.setOrderStatus(item.getOrderStatus());
//            ticket.setCitizenship(item.getCitizenship());

            ticketRepository.save(ticket);
            SUCCESS.setData(ticket);

            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(TicketDto item) {
        TicketEntity ticket=new TicketEntity();

        ticket.setPassenger(item.getPassenger());
        ticket.setTrain(item.getTrain());
        ticket.setFromStation(item.getFromStation());
        ticket.setToStation(item.getToStation());
        ticket.setDate(item.getDate());
        ticket.setWagon(item.getWagon());
        ticket.setSeat(item.getSeat());
        ticket.setOrderStatus(item.getOrderStatus());
//        ticket.setCitizenship(item.getCitizenship());

        ticketRepository.save(ticket);
        return SUCCESS;
    }
}
