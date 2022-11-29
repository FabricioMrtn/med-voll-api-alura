package med.voll.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table
public enum Especialidade {
	ORTOPEDIA,
	CARDIOLOGIA,
	GINECOLOGIA,
	DERMATOLOGIA;
}
