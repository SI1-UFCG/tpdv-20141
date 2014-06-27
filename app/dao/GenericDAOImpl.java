package dao;

import java.util.List;

import javax.persistence.Query;

import play.db.jpa.JPA;

/**
 * Camada genérica para acesso ao Banco de Dados
 */
public class GenericDAOImpl {

	public boolean persist(Object e) {
		JPA.em().persist(e);
		return true;
	}

	public void flush() {
		JPA.em().flush();
	}

	public void merge(Object e) {
		JPA.em().merge(e);
	}

	public <T> T findByEntityId(Class<T> clazz, Long id) {
		return JPA.em().find(clazz, id);
	}

	public <T> List<T> findAllByClassName(Class<T> clazz) {
		String hql = "FROM " + clazz.getCanonicalName();
		Query hqlQuery = JPA.em().createQuery(hql);
		return hqlQuery.getResultList();
	}

	public <T> void removeById(Class<T> classe, Long id) {
		JPA.em().remove(findByEntityId(classe, id));
	}

	public void remove(Object objeto) {
		JPA.em().remove(objeto);
	}

	public <T> T findLatest(Class clazz, String attributeName) {
		Long id = JPA
				.em()
				.createQuery(
						"select max(v." + attributeName + ") from "
								+ clazz.getCanonicalName() + " v", Long.class)
				.getSingleResult();
		return (T) findByEntityId(clazz, id);
	}

	public <T> List<T> findByAttributeName(Class clazz, String attributeName,
			String attributeValue) {
		String hql = "FROM " + clazz.getCanonicalName() + " c" + " WHERE c."
				+ attributeName + " = '" + attributeValue + "'";
		Query hqlQuery = JPA.em().createQuery(hql);
		return hqlQuery.getResultList();
	}

	public Query createQuery(String query) {
		return JPA.em().createQuery(query);
	}
}
