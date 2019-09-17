package com.stackroute.financialadapterneo4j.service;
import com.stackroute.financialadapterneo4j.domain.Item;
import com.stackroute.financialadapterneo4j.domain.Location;
import com.stackroute.financialadapterneo4j.domain.LocationResponse;
import com.stackroute.financialadapterneo4j.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class ItemServiceImplementation implements ItemService {
    private ItemRepository itemRepository;
    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
    //        WebClient client = WebClient.builder()
//                .baseUrl("https://tools.keycdn.com/geo.json?host=69.89.31.226")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        @GetMapping("/ltlon")
//        public Flux<?> getLattitudeAndLongitude() {
//            List<Object> myArray = new ArrayList<>();
//            Flux<?> response = Flux.fromIterable(myArray);
//
//            Flux<Object> objectFlux = client.get()
//                    .retrieve()
//                    .bodyToFlux(Object.class);
//
//            return objectFlux;
//        }
//        List<String> list=new ArrayList<>();
//        public void getLocation(){
//            Object subscribe = this.getLattitudeAndLongitude().subscribe(i -> {
//                System.out.println(i);
//
//            });
//        }
    public Location getLocation(String host) {
        final String api = "https://tools.keycdn.com/geo.json?host=";
        StringBuilder uriBuilder = new StringBuilder(api);
//        WebClient client = WebClient.builder()
//                .baseUrl()
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
        WebClient webClient = WebClient.create();
        LocationResponse outPut = webClient.get()
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
    @Override
    public boolean compareLocations(Location currentTransactionLocation, Location previousTransactionLocation) {
        log.info(currentTransactionLocation.toString());
        log.info(previousTransactionLocation.toString());
        return false;
    }

    @Override
    public long calculateDateDifference(String curentTimeStamp, String oldTimeStamp) {
        return 0;
    }
}