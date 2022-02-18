package uz.pdp.eticketdemo.service.base;

import uz.pdp.eticketdemo.response.ApiResponse;

public interface  BaseService<T> {

    ApiResponse getList();
    ApiResponse getById(Long id);
    ApiResponse delete(Long id);
    ApiResponse edit(Long id, T item);
    ApiResponse add(T item);

}