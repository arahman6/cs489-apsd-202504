package edu.miu.cs.cs489.adsdentalapp.mapper;

import edu.miu.cs.cs489.adsdentalapp.dto.request.AppointmentRequest;
import edu.miu.cs.cs489.adsdentalapp.dto.response.AppointmentResponse;
import edu.miu.cs.cs489.adsdentalapp.model.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "patientName", expression = "java(appointment.getPatient().getFirstName() + \" \" + appointment.getPatient().getLastName())")
    @Mapping(target = "dentistName", expression = "java(appointment.getDentist().getFirstName() + \" \" + appointment.getDentist().getLastName())")
    @Mapping(target = "surgeryName", source = "surgery.name")
    AppointmentResponse toResponse(Appointment appointment);

    Appointment toEntity(AppointmentRequest request);
}
