package edu.miu.cs.cs489.adsdentalapp.mapper;

import edu.miu.cs.cs489.adsdentalapp.dto.request.DentistRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.DentistResponse;
import edu.miu.cs.cs489.adsdentalapp.model.Dentist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DentistMapper {

    @Mapping(target = "fullName", expression = "java(dentist.getFirstName() + \" \" + dentist.getLastName())")
    DentistResponse toResponse(Dentist dentist);

    Dentist toEntity(DentistRequest request);
}
