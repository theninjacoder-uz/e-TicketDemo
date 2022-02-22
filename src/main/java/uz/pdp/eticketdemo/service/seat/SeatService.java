package uz.pdp.eticketdemo.service.seat;

import lombok.RequiredArgsConstructor;
import uz.pdp.eticketdemo.model.dto.train.seat.SeatTypeDto;
import uz.pdp.eticketdemo.model.entity.seat.SeatEntity;
import uz.pdp.eticketdemo.model.entity.seat.SeatStatusEntity;
import uz.pdp.eticketdemo.model.entity.seat.SeatType;
import uz.pdp.eticketdemo.model.entity.wagon.WagonEntity;
import uz.pdp.eticketdemo.repository.seat.SeatRepository;
import uz.pdp.eticketdemo.repository.seat.SeatStatusRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SeatService extends BaseResponse implements BaseService<SeatTypeDto> {

    private final SeatRepository seatRepository;
    private final SeatStatusRepository seatStatusRepository;
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

    public boolean generateSeats(WagonEntity wagon, int numberOfSeats) {

        List<SeatEntity> seatEntityList = new ArrayList<>();
        List<SeatStatusEntity> statusEntities = new ArrayList<>();

        int n = 1;

        while(n < numberOfSeats){
            SeatEntity seat = new SeatEntity();
            seat.setSeatType(SeatType.SITTING);
            seat.setNumber(n);
            seat.setWagon(wagon);

            SeatStatusEntity seatStatus = new SeatStatusEntity();
            seatStatus.setSeat(seat);

            seatEntityList.add(seat);
            statusEntities.add(seatStatus);
            n++;
        }

        seatRepository.saveAll(seatEntityList);
        seatStatusRepository.saveAll(statusEntities);

        return true;
    }//TODO add seat considering seatType
}
