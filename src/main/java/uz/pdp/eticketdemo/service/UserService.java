package uz.pdp.eticketdemo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.eticketdemo.dto.UserDto;
import uz.pdp.eticketdemo.entity.UserEntity;
import uz.pdp.eticketdemo.repository.UserRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends BaseResponse implements BaseService<UserDto> {
    private final UserRepository userRepository;

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
    public ApiResponse edit(@PathVariable Long id, @RequestBody UserDto userDto) {
        Optional<UserEntity> findUserById = userRepository.findById(id);
        if(findUserById.isPresent()){
            UserEntity userEntity = findUserById.get();
            userEntity.setPassword(userDto.getPassword());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPhoneNumber(userDto.getPhoneNumber());
                userRepository.save(userEntity);
            return SUCCESS ;
        }
        return FAILED;
    }

    @Override
    public ApiResponse add(UserDto item) {
        UserEntity user = new UserEntity();
        user.setPassword(item.getPassword());
        user.setPhoneNumber(item.getPhoneNumber());
        userRepository.save(user);
        return null;
    }
}
