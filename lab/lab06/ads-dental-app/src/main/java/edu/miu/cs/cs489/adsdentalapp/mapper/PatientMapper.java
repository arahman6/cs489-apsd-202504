package edu.miu.cs.cs489.adsdentalapp.mapper;

import edu.miu.cs.cs489.adsdentalapp.dto.request.PatientRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.PatientResponse;
import edu.miu.cs.cs489.adsdentalapp.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {

   @Mapping(target = "fullName", expression = "java(patient.getFirstName() + \" \" + patient.getLastName())")
    @Mapping(target = "address", source = "address", qualifiedByName = "formatAddress")
    PatientResponse toResponse(Patient patient);

    Patient toEntity(PatientRequest request);

    @Named("formatAddress")
    default String formatAddress(Object address) {
        if (address == null) return null;
        return address.toString(); // or cast + custom formatting if needed
    }
}
