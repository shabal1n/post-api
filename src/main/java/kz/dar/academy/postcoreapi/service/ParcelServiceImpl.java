package kz.dar.academy.postcoreapi.service;

import kz.dar.academy.postcoreapi.model.ParcelModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ParcelServiceImpl implements ParcelService{
    private static final HashMap<String, ParcelModel> parcelMap = new HashMap<>();

    static {
        ParcelModel parcel1 = new ParcelModel(UUID.randomUUID().toString(), "Ivan Ivanov",
                "Anrey Alexandrov", "Almaty c., Al-farabi, 165", "Kostanay c., Abay, 34",
                1.26, "new");
        ParcelModel parcel2 = new ParcelModel(UUID.randomUUID().toString(), "Sam Smith",
                "Elon Musk", "Nur-Sultan c., Central, 165", "Karaganda c., Dostyk, 14",
                0.15, "received");
        ParcelModel parcel3 = new ParcelModel(UUID.randomUUID().toString(), "Artur Shabalin",
                "Bill Gates", "Almaty c., Kabanbay batyr, 152", "Konaev c., Satbayev, 34",
                5.34, "on the way");

        parcelMap.put(parcel1.getParcelId(), parcel1);
        parcelMap.put(parcel2.getParcelId(), parcel2);
        parcelMap.put(parcel3.getParcelId(), parcel3);
    }

    @Override
    public void addNewParcel(ParcelModel parcelModel) {
        parcelModel.setParcelId(UUID.randomUUID().toString());
        parcelMap.put(parcelModel.getParcelId(), parcelModel);
    }

    @Override
    public void updateParcelById(String parcelId, ParcelModel parcelModel) {
        parcelModel.setParcelId(parcelId);
        parcelMap.put(parcelId, parcelModel);
    }

    @Override
    public List<ParcelModel> getAllParcels() {
        return new ArrayList<>(parcelMap.values());
    }

    @Override
    public ParcelModel getParcelById(String parcelId) {
        return parcelMap.get(parcelId);
    }

    @Override
    public void deleteParcelById(String parcelId) {
        parcelMap.remove(parcelId);
    }
}
