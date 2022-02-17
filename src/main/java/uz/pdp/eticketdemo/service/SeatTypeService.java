package uz.pdp.eticketdemo.service;

import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.dto.SeatTypeDto;
import uz.pdp.eticketdemo.entity.SeatTypeEntity;
import uz.pdp.eticketdemo.repository.SeatTypeRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;

@Service
public class SeatTypeService extends BaseResponse implements BaseService<SeatTypeDto>{

    private final SeatTypeRepository seatTypeRepository;

    //Constructor injection
    public SeatTypeService(SeatTypeRepository seatTypeRepository) {
        this.seatTypeRepository = seatTypeRepository;
    }

    @Override
    public ApiResponse getList() {
        return null;
    }

    @Override
    public ApiResponse getById(Long id) {
        return null;
    }

    @Override
    public ApiResponse delete(Long id) {
        return null;
    }

    @Override
    public ApiResponse edit(Long id, SeatTypeDto item) {
        return null;
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
