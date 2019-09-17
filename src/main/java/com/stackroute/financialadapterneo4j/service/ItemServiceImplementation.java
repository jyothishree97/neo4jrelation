package com.stackroute.financialadapterneo4j.service;

import com.stackroute.financialadapterneo4j.domain.Item;
import com.stackroute.financialadapterneo4j.domain.Location;
import com.stackroute.financialadapterneo4j.domain.LocationResponse;
import com.stackroute.financialadapterneo4j.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
@Service
public class ItemServiceImplementation implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item itemNode(Item item) {
        System.out.println(item);
//        return itemRepository.itemNode(item.getItem_id(),item.getItem_name(),item.getItem_price(),item.getNo_of_items(),item.getParent_id());
        return itemRepository.save(item);
    }

    public Location getLocation(String host) {
        final String api = "https://tools.keycdn.com/geo.json?host=";
        StringBuilder uriBuilder = new StringBuilder(api);
//        WebClient client = WebClient.builder()
//                .baseUrl()
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();

        WebClient webClient = WebClient.create();
        LocationResponse  outPut = webClient.get()
                .uri(uriBuilder.append(host).toString())
                .retrieve()
                .bodyToMono(LocationResponse.class)
                .block();


//        @GetMapping("/ltlon")
//        public Flux<Object> getLattitudeAndLongitude() {
//            List<Object> myArray = new ArrayList<>();
//            Flux<?> response = Flux.fromIterable(myArray);

//            return client.get()
//                    .retrieve()
//                    .bodyToFlux(Object.class);
        return new Location(outPut.getData().getGeo().getLatitude(), outPut.getData().getGeo().getLongitude());
//        }
    }
}
