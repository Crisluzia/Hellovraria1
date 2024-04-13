package ps2.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DisciplinaController {

	private List<Disciplina> disciplina;

	public DisciplinaController() {
		this.disciplina = new ArrayList<>();
		disciplina.add(new Disciplina(1, "Isa", "Terceiro", "Seg", "Segurança"));
		disciplina.add(new Disciplina(2, "Cris", "Terceiro", "PS", "Programação"));
		disciplina.add(new Disciplina(3, "João", "Terceiro", "BD", "Banco de dados"));
    }
	@GetMapping("/api/disciplina")
	Iterable<Disciplina> getDisciplina() {
		return this.disciplina;
	}
	
	@GetMapping("/api/disciplina/{id}")
	Optional<Disciplina> getDisciplina(@PathVariable long id) {
		for (Disciplina d: disciplina) {
			if (d.getId() == id) {
				return Optional.of(d);
			}
		}
		return Optional.empty();
	}
	
	@PostMapping("/api/disciplina")
	Disciplina createDisciplina(@RequestBody Disciplina d) {
		long maxId = 1;
		for (Disciplina disp: disciplina) {
			if (disp.getId() > maxId) {
				maxId = disp.getId();
			}
		}
		d.setId(maxId+1);
		disciplina.add(d);
		return d;
	}
	
	@PutMapping("/api/disciplina/{disciplinaId}")
	Optional<Disciplina> updateDisciplina(@RequestBody Disciplina disciplinaRequest, @PathVariable long disciplinaId) {
		Optional<Disciplina> opt = this.getDisciplina(disciplinaId);
		if (opt.isPresent()) {
			Disciplina disciplina = opt.get();
			disciplina.setNome(disciplinaRequest.getNome());
            disciplina.setSemestre(disciplinaRequest.getSemestre());
			disciplina.setSigla(disciplinaRequest.getSigla());
			disciplina.setCurso(disciplinaRequest.getCurso());
		}

		return opt;				
	}	
	
	@DeleteMapping(value = "/api/disciplina/{id}")
	void deleteDisciplina(@PathVariable long id) {
		disciplina.removeIf(d -> d.getId() == id);
	}		
}


