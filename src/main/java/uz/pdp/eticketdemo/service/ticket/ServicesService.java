package uz.pdp.eticketdemo.service.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.ticket.ServicesDto;
import uz.pdp.eticketdemo.model.entity.ticket.ServicesEntity;
import uz.pdp.eticketdemo.repository.ticket.ServicesRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicesService extends BaseResponse implements BaseService<ServicesDto> {
    private final ServicesRepository servicesRepository;
    @Override
    public ApiResponse getList() {
        List<ServicesEntity> list = servicesRepository.findAll();
        SUCCESS.setData(list);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<ServicesEntity> optional = servicesRepository.findById(id);

        if(optional.isPresent()){
            SUCCESS.setData(optional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = servicesRepository.existsById(id);
        if(exists) {
            servicesRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, ServicesDto item) {
        Optional<ServicesEntity> optional = servicesRepository.findById(id);

        if(optional.isPresent()){
            ServicesEntity service = optional.get();

            service.setName(item.getName());
            service.setDescription(item.getDescription());
            service.setPrice(item.getPrice());
            servicesRepository.save(service);
            SUCCESS.setData(service);

            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(ServicesDto item) {
        ServicesEntity service=new ServicesEntity();

        service.setName(item.getName());
        service.setDescription(item.getDescription());
        service.setPrice(item.getPrice());
        servicesRepository.save(service);

        return SUCCESS;
    }
}
