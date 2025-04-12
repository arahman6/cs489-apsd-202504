package edu.miu.cs.cs489.adsdentalapp.config;

import edu.miu.cs.cs489.adsdentalapp.model.*;
import edu.miu.cs.cs489.adsdentalapp.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            PatientRepository patientRepository,
            DentistRepository dentistRepository,
            AppointmentRepository appointmentRepository,
            AddressRepository addressRepository,
            SurgeryRepository surgeryRepository,
            RoleRepository roleRepository,
            UserRepository userRepository
    ) {
        return args -> {
            // --- Address ---
            Address a1 = addressRepository.save(new Address("Main St", "Fairfield", "IA", "52557"));
            Address a2 = addressRepository.save(new Address("Oak Dr", "Des Moines", "IA", "50309"));

            // --- Patients ---
            Patient p1 = patientRepository.save(new Patient("P105", "Jill", "Bell", "(641) 472-6677", a1));
            Patient p2 = patientRepository.save(new Patient("P108", "Ian", "MacKay", "(641) 472-2211", a2));

            // --- Dentists ---
            Dentist d1 = dentistRepository.save(new Dentist("Tony", "Smith", "General", "tony@ads.com", "555-1111"));
            Dentist d2 = dentistRepository.save(new Dentist("Helen", "Pearson", "Orthodontist", "helen@ads.com", "555-2222"));

            // --- Surgeries ---
            Surgery s1 = surgeryRepository.save(new Surgery("S15", "South Surgery", a1));
            Surgery s2 = surgeryRepository.save(new Surgery("S10", "Central Surgery", a2));

            // --- Appointments ---
            appointmentRepository.saveAll(List.of(
                    new Appointment("A001", "Checkup", 100.0, LocalDate.of(2023, 10, 12), LocalTime.of(10, 0),
                            "Routine", p1, d1, s1),
                    new Appointment("A002", "Braces Consultation", 200.0, LocalDate.of(2023, 10, 14), LocalTime.of(14, 30),
                            "Consultation", p2, d2, s2)
            ));

            // --- Roles ---
            Role adminRole = roleRepository.save(new Role("ADMIN"));
            Role staffRole = roleRepository.save(new Role("STAFF"));

            // --- Users ---
            userRepository.saveAll(List.of(
                    new User("admin", "admin123", adminRole),
                    new User("dentalstaff", "staff123", staffRole)
            ));

            System.out.println("Sample data initialized successfully!");
        };
    }
}
