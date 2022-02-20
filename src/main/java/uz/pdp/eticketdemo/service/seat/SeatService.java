package uz.pdp.eticketdemo.service.seat;

import uz.pdp.eticketdemo.model.dto.train.seat.SeatTypeDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

public class SeatService extends BaseResponse implements BaseService<SeatTypeDto> {
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

    @Override
    public ApiResponse add(SeatTypeDto item) {
        return null;
    }
}
