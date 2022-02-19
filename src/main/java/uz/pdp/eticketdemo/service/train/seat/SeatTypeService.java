package uz.pdp.eticketdemo.service.train.seat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.train.seat.SeatTypeDto;
import uz.pdp.eticketdemo.model.entity.train.seats.SeatTypeEntity;
import uz.pdp.eticketdemo.repository.train.seat.SeatTypeRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import static uz.pdp.eticketdemo.response.BaseResponse.*;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatTypeService implements BaseService<SeatTypeDto> {

    private final SeatTypeRepository seatTypeRepository;

    //Constructor injection
//    @Autowired
//    public SeatTypeService(SeatTypeRepository seatTypeRepository) {
//        this.seatTypeRepository = seatTypeRepository;
//    }

    //get all seats
    @Override
    public ApiResponse getList() {
        List<SeatTypeEntity> list = seatTypeRepository.findAll();
        SUCCESS.setData(list);
        return SUCCESS;
    }

    //find by id
    @Override
    public ApiResponse getById(Long id) {

        Optional<SeatTypeEntity> optional = seatTypeRepository.findById(id);

        if(optional.isPresent()){
            SUCCESS.setData(optional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    //delete
    @Override
    public ApiResponse delete(Long id) {

        boolean exists = seatTypeRepository.existsById(id);
        if(exists) {
            seatTypeRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    //update
    @Override
    public ApiResponse edit(Long id, SeatTypeDto item) {
        Optional<SeatTypeEntity> optional = seatTypeRepository.findById(id);
        if(optional.isPresent()){
            SeatTypeEntity seatType = optional.get();
            seatType.setDescription(item.getDescription());
            seatType.setName(item.getName());
            seatTypeRepository.save(seatType);
            SUCCESS.setData(seatType);

            return SUCCESS;
        }
        return NOT_FOUND;
    }

    //add seat type to DB
    @Override
    public ApiResponse add(SeatTypeDto item) {
        SeatTypeEntity seatType = new SeatTypeEntity();
        seatType.setName(item.getName());
        seatType.setDescription(item.getDescription());
        seatTypeRepository.save(seatType);
        return SUCCESS;
    }
}
