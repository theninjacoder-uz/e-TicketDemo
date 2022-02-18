package uz.pdp.eticketdemo.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eticketdemo.model.dto.user.DocTypeDto;
import uz.pdp.eticketdemo.model.entity.user.DocTypeEntity;
import uz.pdp.eticketdemo.repository.user.DocTypeRepository;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.base.BaseService;

import java.util.List;
import java.util.Optional;

import static uz.pdp.eticketdemo.response.BaseResponse.*;

@Service
@RequiredArgsConstructor
public class DocTypeService implements BaseService<DocTypeDto> {
    private final DocTypeRepository doctypeRepository;

    @Override
    public ApiResponse getList() {
        List<DocTypeEntity> list = doctypeRepository.findAll();
        SUCCESS.setData(list);
        return SUCCESS;
    }

    @Override
    public ApiResponse getById(Long id) {
        Optional<DocTypeEntity> optional = doctypeRepository.findById(id);

        if(optional.isPresent()){
            SUCCESS.setData(optional.get());
            return SUCCESS;
        }

        return NOT_FOUND;
    }

    @Override
    public ApiResponse delete(Long id) {
        boolean exists = doctypeRepository.existsById(id);
        if(exists) {
            doctypeRepository.deleteById(id);
            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse edit(Long id, DocTypeDto item) {
        Optional<DocTypeEntity> optional = doctypeRepository.findById(id);

        if(optional.isPresent()){
            DocTypeEntity docType = optional.get();

            docType.setName(item.getName());

            doctypeRepository.save(docType);
            SUCCESS.setData(docType);

            return SUCCESS;
        }
        return NOT_FOUND;
    }

    @Override
    public ApiResponse add(DocTypeDto item) {
        DocTypeEntity docType=new DocTypeEntity();

        docType.setName(item.getName());

        doctypeRepository.save(docType);

        return SUCCESS;
    }
}
