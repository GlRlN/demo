package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Store;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreRequest {
    private String name;
    private String owner;
    private String place;

    public Store toEntity(){
       Store store = new Store();
       store.setName(name);
       store.setOwner(owner);
       store.setPlace(place);
       return store;
    }
}
