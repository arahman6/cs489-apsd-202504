package edu.miu.cs.cs489.adsdentalapp.service;

import edu.miu.cs.cs489.adsdentalapp.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAllAddressesSortedByCity();
}
