package uz.pdp.eticketdemo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.dto.UserDto;
import uz.pdp.eticketdemo.entity.user.UserEntity;
import uz.pdp.eticketdemo.repository.UserRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.response.BaseResponse;


@Service
@RequiredArgsConstructor
public class UserService extends BaseResponse implements BaseService<UserDto>{
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
    public ApiResponse edit(Long id, UserDto item) {
        return null;
    }

    @Override
    public ApiResponse add(UserDto item) {
        UserEntity user = new UserEntity();
        user.setPassword(item.getPassword());
        user.setPhoneNumber(item.getPhoneNumber());
        userRepository.save(user);
        return SUCCESS;
    }
}
