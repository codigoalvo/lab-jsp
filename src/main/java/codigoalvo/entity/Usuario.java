package codigoalvo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 4860641136563274996L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Length(min = 3, max = 50)
	private String login;

	@NotNull
	@Length(min = 4, max = 30)
	private String senha;

	@NotNull
	@NotBlank
	@Length(max = 150)
	private String nome;

	@NotNull
	@NotBlank
	@Length(max = 250)
	@Email
	private String email;

	@NotNull
	@Enumerated(EnumType.STRING)
	private UsuarioTipo tipo;

	@Lob
	private byte[] imagem;

	private Date dataInativo;

	private Date dataUltimaAlteracaoSenha;

	private Date dataUltimoLogin;

	private Date dataUltimaFalhaLogin;

	private Integer tentativasLoginInvalido;

//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="USUARIO_ID")
//	private List<Categoria> categorias = new ArrayList<Categoria>();

//	public List<Categoria> getCategorias() {
//		return categorias;
//	}
//
//	public void setCategorias(List<Categoria> categorias) {
//		this.categorias = categorias;
//	}

	public Usuario() {
	}

	public Usuario(String login, String senha, String nome, String email, UsuarioTipo tipo) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return this.login;
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
		Usuario other = (Usuario) obj;
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsuarioTipo getTipo() {
		return this.tipo;
	}

	public void setTipo(UsuarioTipo tipo) {
		this.tipo = tipo;
	}

	public byte[] getImagem() {
		return this.imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Boolean getAtivo() {
		return this.dataInativo == null || this.dataInativo.after(new Date());
	}

	public void setAtivo(Boolean ativo) {
		if (ativo) {
			this.dataInativo = null;
		} else {
			this.dataInativo = new Date();
		}
	}

	public Date getDataInativo() {
		return this.dataInativo;
	}

	public void setDataInativo(Date dataInativo) {
		this.dataInativo = dataInativo;
	}

	public Date getDataUltimaAlteracaoSenha() {
		return this.dataUltimaAlteracaoSenha;
	}

	public void setDataUltimaAlteracaoSenha(Date dataUltimaAlteracaoSenha) {
		this.dataUltimaAlteracaoSenha = dataUltimaAlteracaoSenha;
	}

	public Date getDataUltimoLogin() {
		return this.dataUltimoLogin;
	}

	public void setDataUltimoLogin(Date dataUltimoLogin) {
		this.dataUltimoLogin = dataUltimoLogin;
	}

	public Date getDataUltimaFalhaLogin() {
		return this.dataUltimaFalhaLogin;
	}

	public void setDataUltimaFalhaLogin(Date dataUltimaFalhaLogin) {
		this.dataUltimaFalhaLogin = dataUltimaFalhaLogin;
	}

	public Integer getTentativasLoginInvalido() {
		return this.tentativasLoginInvalido;
	}

	public void setTentativasLoginInvalido(Integer tentativasLoginInvalido) {
		this.tentativasLoginInvalido = tentativasLoginInvalido;
	}

}
