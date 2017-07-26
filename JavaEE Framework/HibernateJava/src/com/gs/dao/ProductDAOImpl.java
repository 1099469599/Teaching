package com.gs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gs.bean.Product;
import com.gs.util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Product add(Product product) {
		// ͨ��sessionFactory�����ȡsession���ݿ����� 
		Session session = sessionFactory.openSession(); // ����������
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit(); // �����ύ
		session.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Product queryById(int id) {
		Session session = sessionFactory.openSession();
		// Product p = (Product) session.get(Product.class, id); // get����ͨ��ָ������������ѯ��������
		// Query query = session.createQuery("from Product p where p.id = ?");
		// query.setInteger(0, id); // ����������0��ʼ 
		Query query = session.createQuery("from Product p where p.id =:pid");
		query.setParameter("pid", id);
		// List<Product> products = query.list(); // ����Ƕ��м�¼����ʹ��list����
		Product p = (Product) query.uniqueResult(); // ���ȷ����ѯ���Ľ��ֻ��һ�м�¼����ֱ��ʹ��uniqueResult���� 
		session.close();
		// return products.size() == 1 ? products.get(0) : null;
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> queryAll() {
		Session session = sessionFactory.openSession();
		List<Product> products = session.createQuery("from Product").list();
		session.close();
		return products;
	}

	@Override
	public void update(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product); // ���Ҫɾ��ĳ��object�����object�������ֶε����Ա��븳ֵ
		transaction.commit();
		session.close();
	}

}
