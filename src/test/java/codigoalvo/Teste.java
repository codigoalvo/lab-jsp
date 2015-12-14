package codigoalvo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import codigoalvo.entity.Usuario;
import codigoalvo.entity.UsuarioTipo;
import codigoalvo.repository.UsuarioDao;
import codigoalvo.repository.UsuarioDaoJpa;
import codigoalvo.util.EntityManagerUtil;

public class Teste {

	static UsuarioDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new UsuarioDaoJpa(EntityManagerUtil.getEntityManager());
	}

	@Test
	public void test() {
		Usuario usuario = null;
		try {
			dao.beginTransaction();
			usuario = dao.criar(new Usuario("teste", "Teste", "teste@email.com", UsuarioTipo.USER));
			dao.commit();
		} catch (Exception exc) {
			dao.rollback();
		}
		System.out.println(usuario);
		assertTrue("Usuário não deveria ser null", usuario != null);
	}

}
