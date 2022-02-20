package uz.pdp.eticketdemo.service.ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.ticket.OrderStatusDto;
import uz.pdp.eticketdemo.model.entity.order.OrderStatusEntity;
import uz.pdp.eticketdemo.repository.ticket.OrderStatusRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

import static uz.pdp.eticketdemo.response.BaseResponse.*;

@Service
@RequiredArgsConstructor
public class OrderStatusService implements BaseService<OrderStatusDto> {
    private final OrderStatusRepository orderStatusRepository;

    @Override
    public ApiResponse getList() {
        List<OrderStatusEntity> list = orderStatusRepository.findAll();
        SUCCESS.setData(list);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<OrderStatusEntity> optional = orderStatusRepository.findById(id);

        if(optional.isPresent()){
            SUCCESS.setData(optional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = orderStatusRepository.existsById(id);
        if(exists) {
            orderStatusRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, OrderStatusDto item) {
        Optional<OrderStatusEntity> optional = orderStatusRepository.findById(id);

        if(optional.isPresent()){
            OrderStatusEntity orderStatus = optional.get();

            orderStatus.setName(item.getName());

            orderStatusRepository.save(orderStatus);
            SUCCESS.setData(orderStatus);

            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(OrderStatusDto item) {
        OrderStatusEntity orderStatus=new OrderStatusEntity();

        orderStatus.setName(item.getName());

        orderStatusRepository.save(orderStatus);

        return SUCCESS;
    }
}
