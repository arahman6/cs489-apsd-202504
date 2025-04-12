package edu.miu.cs.cs489.adsdentalapp.mapper;

import edu.miu.cs.cs489.adsdentalapp.dto.request.SurgeryRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.SurgeryResponse;
import edu.miu.cs.cs489.adsdentalapp.model.Surgery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SurgeryMapper {

    @Mapping(target = "address", source = "address", qualifiedByName = "formatAddress")
    SurgeryResponse toResponse(Surgery surgery);

    Surgery toEntity(SurgeryRequest request);

    @Named("formatAddress")
    default String formatAddress(Object address) {
        return address != null ? address.toString() : null;
    }
}
