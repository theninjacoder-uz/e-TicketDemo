package uz.pdp.eticketdemo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.DocTypeDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.DocTypeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doc_type")
public class DocTypeController {
    private final DocTypeService service;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody DocTypeDto docTypeDto){
        return service.add(docTypeDto);
    }

    @GetMapping("/list")
    public ApiResponse getList(){
        return service.getList();
    }

    @GetMapping("/get")
    public ApiResponse getById(@RequestParam(name = "id") Long id){
        return service.getById(id);
    }

    @PostMapping("/edit")
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody DocTypeDto docTypeDto){
        return service.edit(id, docTypeDto);
    }


}
