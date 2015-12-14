package codigoalvo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(indexes = {	@Index(name = "idx_categoria_nome_unique", columnList = "nome, usuario_id", unique = true) })
public class Categoria implements Serializable {

	private static final long serialVersionUID = -4407612096913713967L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotBlank
	@Length(max = 100)
	private String nome;

	@ManyToOne(cascade=CascadeType.REMOVE)
//	@JoinColumn(//columnDefinition = "usuario_id INT CONSTRAINT fk_categoria_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE")
//	foreignKey = @ForeignKey(name="fk_categoria_usuario", foreignKeyDefinition="fk_categoria_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE"))
	private	Usuario usuario;

	public Categoria() {
	}

	public Categoria(String nome) {
		this();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(
	Usuario usuario) {
		this.usuario = usuario;
	}

}
