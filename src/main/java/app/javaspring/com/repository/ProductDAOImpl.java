package app.javaspring.com.repository;

import app.javaspring.com.SessionFactoryUtils;
import app.javaspring.com.models.Product;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDAOImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.find(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("SELECT p from Product p", Product.class).getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.remove(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            String t = product.getTitle();
            TypedQuery<Product> query = session.createQuery("SELECT p FROM Product p where p.title=:title", Product.class);
            query.setParameter("title", t);
            List<Product> productList = query.getResultList();
            Product p;
            if (productList.size()==0){
                p = product;
                session.persist(p);
            }else {
                p = productList.get(0);
                p.setPrice(product.getPrice());
            }
            session.getTransaction().commit();
            return p;
        }
    }
}
