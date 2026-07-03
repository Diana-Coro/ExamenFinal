package SIS_414.ExamenFinal.Service;

import SIS_414.ExamenFinal.Entity.Doctor;
import SIS_414.ExamenFinal.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> listarDoctores() {
        return doctorRepository.findAll();
    }

    public Doctor buscarDoctorPorId(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor guardarDoctor(Doctor doctor) {
        doctor.setId(null);
        return doctorRepository.save(doctor);
    }

    public Doctor actualizarDoctor(Long id, Doctor datos) {
        Doctor doctor = buscarDoctorPorId(id);

        if (doctor == null) {
            return null;
        }

        doctor.setNombre(datos.getNombre());
        doctor.setFechaIngreso(datos.getFechaIngreso());
        doctor.setArea(datos.getArea());
        doctor.setCelular(datos.getCelular());
        doctor.setEspecialidad(datos.getEspecialidad());

        return doctorRepository.save(doctor);
    }

    public void eliminarDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
