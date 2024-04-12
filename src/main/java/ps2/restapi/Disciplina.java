package ps2.restapi;

public class Disciplina {
	private long id;
	private String nome;
	private String semestre;
	private String sigla;
    private String curso;
		
	public Disciplina() {}
	public Disciplina(long id, String n, String s, String si, String c) {
		this.id = id;
		this.nome = n;
		this.semestre = s;
		this.sigla = si;
        this.curso = c;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
    public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

}