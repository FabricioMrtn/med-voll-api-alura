package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.dto.PacienteDto;
import med.voll.api.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
