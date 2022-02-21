package uz.pdp.eticketdemo.service.train.seat;

import lombok.RequiredArgsConstructor;
import uz.pdp.eticketdemo.model.dto.train.seat.SeatTypeDto;
import uz.pdp.eticketdemo.model.entity.train.seats.SeatEntity;
import uz.pdp.eticketdemo.repository.train.seat.SeatRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SeatService extends BaseResponse implements BaseService<SeatTypeDto> {

    private final SeatRepository seatRepository;
    @Override
    public ApiResponse getList() {
        List<SeatEntity> allSeats = seatRepository.findAll();
        SUCCESS.setData(allSeats);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<SeatEntity> findById = seatRepository.findById(id);
            if(findById.isPresent()) {
                SUCCESS.setData(findById.get());
                return SUCCESS;
            }
            return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean b = seatRepository.existsById(id);
        if(b){
            seatRepository.deleteById(id);
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, SeatTypeDto item) {
        Optional<SeatEntity> byId = seatRepository.findById(id);
        if(byId.isPresent()){
            SeatEntity seatEntity = byId.get();
            seatEntity.setNumber(item.getNumber());
            seatRepository.save(seatEntity);

            SUCCESS.setData(seatEntity);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(SeatTypeDto item) {
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setNumber(item.getNumber());
        seatRepository.save(seatEntity);
        return SUCCESS;
    }
}
