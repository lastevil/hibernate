package app.javaspring.com;

import app.javaspring.com.models.Product;
import app.javaspring.com.repository.ProductDAO;
import app.javaspring.com.repository.ProductDAOImpl;

public class AppStart {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDAO productDAO = new ProductDAOImpl(sessionFactoryUtils);
            productDAO.deleteById(3l);
            System.out.println("---> " + productDAO.findById(2l));
            System.out.println("---> " + productDAO.saveOrUpdate(
                    new Product("First1", 6)
            ));
            System.out.println("---> ALL: " + productDAO.findAll());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shotdown();
        }
    }
}
