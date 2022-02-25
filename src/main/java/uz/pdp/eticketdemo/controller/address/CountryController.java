package uz.pdp.eticketdemo.controller.address;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.address.CountryDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.address.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService service;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody CountryDto countryDto){
        return service.add(countryDto);
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
    public ApiResponse edit(@RequestParam(name = "id") Long id, @RequestBody CountryDto countryDto){
        return service.edit(id, countryDto);
    }

    @DeleteMapping("/delete")
    public ApiResponse delete(@RequestParam(name = "id") Long id){
        return service.delete(id);
    }
}
