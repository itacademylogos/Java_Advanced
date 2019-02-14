	package ua.lviv.lgs.dao.impl;
	
	import java.util.ArrayList;
	import java.util.List;
	
	import javax.persistence.EntityManager;
	import javax.persistence.TypedQuery;
	import javax.persistence.criteria.CriteriaBuilder;
	import javax.persistence.criteria.CriteriaQuery;
	import javax.persistence.criteria.Root;
	
	import ua.lviv.lgs.dao.UserDao;
	import ua.lviv.lgs.domain.User;
	import ua.lviv.lgs.shared.FactoryManager;
	
	public class UserDaoImpl implements UserDao {
		private EntityManager em = FactoryManager.getEntityManager();
	
		@Override
		public User create(User user) {
			try {
				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			return user;
		}
	
		@Override
		public User read(Integer id) {
			User user = null;
			try {
				user = em.find(User.class, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			return user;
		}
	
		@Override
		public User update(User user) {
			try {
				// TODO: to be implemented
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			return user;
	
		}
	
		@Override
		public void delete(Integer id) {
			try {
				// TODO: to be implemented
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		@Override
		public List<User> readAll() {
			List<User> userRecords = new ArrayList<>();
			try {
				// TODO: to be implemented
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			return userRecords;
		}
	
		@Override
		public User getUserByEmail(String email) {
			User user = null;
			try {
				CriteriaBuilder builder = em.getCriteriaBuilder();
				CriteriaQuery<User> criteria = builder.createQuery(User.class);
				Root<User> from = criteria.from(User.class);
				criteria.select(from);
				criteria.where(builder.equal(from.get("email"), email));
				TypedQuery<User> typed = em.createQuery(criteria);
				user = typed.getSingleResult();

			} catch (Exception e) {
				e.printStackTrace();
			}
	
			return user;
	
		}
	
	}
