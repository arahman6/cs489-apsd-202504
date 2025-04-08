**1.1 Functional Requirements (List of Short Statements)**
----------------------------------------------------------

Here's a distilled list of **functional requirements** based on the problem description:

1.  The system shall allow the Office Manager to register Dentists.

2.  The system shall store each Dentist's unique ID, name, contact number, email, and specialization.

3.  The system shall allow the Office Manager to enroll new Patients.

4.  The system shall store each Patient's name, contact info, mailing address, and date of birth.

5.  Patients shall be able to request appointments via phone or an online form.

6.  The Office Manager shall be able to book appointments for Patients with Dentists.

7.  The system shall send a confirmation email upon appointment booking.

8.  Dentists shall be able to sign in and view all their upcoming Appointments.

9.  Appointments shall include the Patient's details and be linked to a Surgery location.

10. Surgeries shall have a name, address, and contact number.

11. Patients shall be able to sign in and view their upcoming Appointments.

12. Patients shall be able to request to cancel or change an Appointment.

13. The system shall restrict a Dentist to a maximum of 5 appointments per week.

14. The system shall prevent appointment requests from Patients with unpaid bills.




**1.2 Domain Model UML Class Diagram**
--------------------------------------

Here are the **main entities** and their relationships:

### Suggested Classes and Attributes:

#### 1\. **Dentist**

-   `dentistId: String`

-   `firstName: String`

-   `lastName: String`

-   `phone: String`

-   `email: String`

-   `specialization: String`

#### 2\. **Patient**

-   `patientId: String`

-   `firstName: String`

-   `lastName: String`

-   `phone: String`

-   `email: String`

-   `address: String`

-   `dateOfBirth: Date`

-   `hasUnpaidBill: Boolean`

#### 3\. **Appointment**

-   `appointmentId: String`

-   `dateTime: DateTime`

-   `status: String` (Scheduled, Cancelled, Completed)

-   `confirmationSent: Boolean`

#### 4\. **Surgery**

-   `surgeryId: String`

-   `name: String`

-   `address: String`

-   `phone: String`



### Relationships and Multiplicities

| Relationship | Description |
| --- | --- |
| Patient "1" ⟷ "0..*" Appointment | One patient can have many appointments |
| Dentist "1" ⟷ "0..5" Appointment | A dentist can have up to 5 appointments/week |
| Appointment "1" ⟷ "1" Surgery | Each appointment is tied to one surgery |
| Appointment "1" ⟷ "1" Dentist | Each appointment is with one dentist |
| Appointment "1" ⟷ "1" Patient | Each appointment is with one patient |



