package uz.pdp.eticketdemo.service.station;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.repository.station.ScheduleRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

@Service
@RequiredArgsConstructor
public class ScheduleService implements BaseService<Object> {

    private final ScheduleRepository repository;

    public ApiResponse getSchedulesByRegionAndDate(Long fId, Long tId, String date){

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
    public ApiResponse edit(Long id, Object item) {
        return null;
    }

    @Override
    public ApiResponse add(Object item) {
        return null;
    }
}
