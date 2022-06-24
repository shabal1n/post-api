package kz.dar.academy.postcoreapi.service;

import kz.dar.academy.postcoreapi.model.ParcelModel;

import java.util.List;

public interface ParcelService {
    void addNewParcel(ParcelModel parcelModel);
    void updateParcelById(String parcelId, ParcelModel parcelModel);
    List<ParcelModel> getAllParcels();
    ParcelModel getParcelById(String parcelId);
    void deleteParcelById(String parcelId);
}
