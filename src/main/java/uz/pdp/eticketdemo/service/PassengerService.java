package uz.pdp.eticketdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.dto.PassengerDto;
import uz.pdp.eticketdemo.entity.PassengerEntity;
import uz.pdp.eticketdemo.repository.PassengerRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;

@Service
@RequiredArgsConstructor
public class PassengerService extends BaseResponse implements BaseService<PassengerDto>{
    private final PassengerRepository passengerRepository;

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
    public ApiResponse edit(Long id, PassengerDto item) {



        return null;
    }

    @Override
    public ApiResponse add(PassengerDto item) {
        PassengerEntity passenger=new PassengerEntity();

        passenger.setUserEntity(item.getUser());
        passenger.setFirstName(item.getFirstName());
        passenger.setLastName(item.getLastName());
        passenger.setGender(item.getGender());
        passenger.setBirthDate(item.getBirthDate());
        passenger.setPassportNumber(item.getPassportNumber());
        passenger.setPassportExpirationDate(item.getPassportExpirationDate());
        passenger.setCitizenship(item.getCitizenship());

        passengerRepository.save(passenger);
        return SUCCESS;
    }
}
