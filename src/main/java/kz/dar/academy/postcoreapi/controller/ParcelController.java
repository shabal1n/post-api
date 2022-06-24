package kz.dar.academy.postcoreapi.controller;

import kz.dar.academy.postcoreapi.model.ParcelModel;
import kz.dar.academy.postcoreapi.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @PostMapping
    public ResponseEntity<String> addNewParcel(@RequestBody ParcelModel parcelModel) {
        parcelService.addNewParcel(parcelModel);
        return new ResponseEntity<>("Parcel was added", HttpStatus.OK);
    }

    @PutMapping("/{parcelId}")
    public ResponseEntity<String> updateParcelById(@PathVariable String parcelId,
                                                   @RequestBody ParcelModel parcelModel) {
        parcelService.updateParcelById(parcelId, parcelModel);
        return new ResponseEntity<>("Parcel was updated", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ParcelModel> getAllParcels() {
        return parcelService.getAllParcels();
    }

    @GetMapping("/{parcelId}")
    public ParcelModel getParcelById(@PathVariable String parcelId) {
        return parcelService.getParcelById(parcelId);
    }

    @DeleteMapping("/{parcelId}")
    public ResponseEntity<String> deleteParcelById(@PathVariable String parcelId) {
        parcelService.deleteParcelById(parcelId);
        return new ResponseEntity<>("Deleted a parcel", HttpStatus.OK);
    }
}
