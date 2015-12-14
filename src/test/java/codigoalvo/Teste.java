package codigoalvo;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import codigoalvo.entity.Categoria;
import codigoalvo.entity.Usuario;
import codigoalvo.entity.UsuarioTipo;
import codigoalvo.repository.CategoriaDao;
import codigoalvo.repository.CategoriaDaoJpa;
import codigoalvo.repository.UsuarioDao;
import codigoalvo.repository.UsuarioDaoJpa;
import codigoalvo.util.EntityManagerUtil;

public class Teste {

	static UsuarioDao uDao;
	static CategoriaDao cDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EntityManagerUtil.initialize();
		uDao = new UsuarioDaoJpa(EntityManagerUtil.getEntityManager());
		cDao = new CategoriaDaoJpa(uDao.getEntityManager());
	}

	@Test
	public void test() {
		Usuario usuario = null;

		try {
			uDao.beginTransaction();
			Usuario tmp = new Usuario("teste", "senha", "Usuário Teste", "teste@email.com", UsuarioTipo.USER);
			usuario = uDao.criar(tmp);
			uDao.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			uDao.rollback();

		}
		System.out.println(usuario);
		Categoria categoria = null;
		try {
			cDao.beginTransaction();
			Categoria cat = new Categoria("Categoria Teste");
			cat.setUsuario(usuario);
			categoria = cDao.criar(cat);
			cDao.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			cDao.rollback();
		}
		System.out.println(categoria);
		assertTrue("Usuário não deveria ser null", usuario != null);
	}

}
