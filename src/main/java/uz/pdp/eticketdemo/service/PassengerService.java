package uz.pdp.eticketdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.PassengerDto;
import uz.pdp.eticketdemo.model.entity.user.PassengerEntity;
import uz.pdp.eticketdemo.repository.PassengerRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;

import java.util.List;
import java.util.Optional;
import static uz.pdp.eticketdemo.response.BaseResponse.*;

@Service
@RequiredArgsConstructor
public class PassengerService implements BaseService<PassengerDto>{
    private final PassengerRepository passengerRepository;

    @Override
    public ApiResponse getList() {
        List<PassengerEntity> list = passengerRepository.findAll();
        SUCCESS.setData(list);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<PassengerEntity> optional = passengerRepository.findById(id);

        if(optional.isPresent()){
            SUCCESS.setData(optional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = passengerRepository.existsById(id);
        if(exists) {
            passengerRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, PassengerDto item) {

        Optional<PassengerEntity> optional = passengerRepository.findById(id);

        if(optional.isPresent()){
            PassengerEntity passenger = optional.get();
            passenger.setUserEntity(item.getUser());
            passenger.setFirstName(item.getFirstName());
            passenger.setLastName(item.getLastName());
            passenger.setGender(item.getGender());
            passenger.setBirthDate(item.getBirthDate());
            passenger.setDocType(item.getDocType());
            passenger.setPassportNumber(item.getPassportNumber());
            passenger.setPassportExpirationDate(item.getPassportExpirationDate());
//            passenger.setCitizenship(item.getCitizenship());

            passengerRepository.save(passenger);
            SUCCESS.setData(passenger);

            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(PassengerDto item) {
        PassengerEntity passenger=new PassengerEntity();

        passenger.setUserEntity(item.getUser());
        passenger.setFirstName(item.getFirstName());
        passenger.setLastName(item.getLastName());
        passenger.setGender(item.getGender());
        passenger.setBirthDate(item.getBirthDate());
        passenger.setDocType(item.getDocType());
        passenger.setPassportNumber(item.getPassportNumber());
        passenger.setPassportExpirationDate(item.getPassportExpirationDate());
//        passenger.setCitizenship(item.getCitizenship());

        passengerRepository.save(passenger);
        return SUCCESS;
    }
}
