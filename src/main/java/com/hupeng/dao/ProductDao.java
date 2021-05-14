package com.hupeng.dao;

import com.hupeng.model.Product;
import com.hupeng.model.User;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    //private ProductDao productDao=new ProductDao();

    @Override
    public int save(Product product ,Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,Price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBlob(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {

        /**
         * Delete a product by productId
         * @return int
         */
            int result=0;
            PreparedStatement st= null;
            String sql="delete * from product where ProductId='"+productId+"'";
            st = con.prepareStatement(sql);
            result=st.executeUpdate(sql);
            return result;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql="update product set ProductName='"+instance.getProductName()+"'"+","+"ProductDescription='"+instance.getProductDescription()+"'"+","+"Picture='"+instance.getPicture()+"'"
                +","+"Price='"+instance.getPrice()+"'"+","+"CategoryId='"+instance.getCategoryId()+"'"+"where ProductId='"+instance.getProductId()+"'";
        PreparedStatement st=con.prepareStatement(sql);
        int result=st.executeUpdate();
        return result;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException{
        String sql="select * from product where ProductId='"+productId+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        Product product=null;
        while(result.next()) {
            product = new Product();
            product.setProductId(result.getInt("ProductId"));
            product.setProductName(result.getString("ProductName"));
            product.setProductDescription(result.getString("ProductDescription"));
            product.setPicture(result.getBinaryStream("Picture"));
            product.setPrice(result.getDouble("Price"));
            product.setCategoryId(result.getInt("CategoryId"));

        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        String sql="select * from product where CategoryId='"+categoryId+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<Product> products=new ArrayList<>();
        while(result.next()){
            Product product = new Product();
            product.setProductId(result.getInt("ProductId"));
            product.setProductName(result.getString("ProductName"));
            product.setProductDescription(result.getString("ProductDescription"));
            product.setPicture(result.getBinaryStream("Picture"));
            product.setPrice(result.getDouble("Price"));
            product.setCategoryId(result.getInt("CategoryId"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql="select * from product where Price<'"+maxPrice+"'"+"and Price>'"+minPrice+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<Product> products=new ArrayList<>();
        while(result.next()){
            Product product = new Product();
            product.setProductId(result.getInt("ProductId"));
            product.setProductName(result.getString("ProductName"));
            product.setProductDescription(result.getString("ProductDescription"));
            product.setPicture(result.getBinaryStream("Picture"));
            product.setPrice(result.getDouble("Price"));
            product.setCategoryId(result.getInt("CategoryId"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {

        String sql="select * from product";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<Product> products=new ArrayList<>();
        while(result.next()){
            Product product = new Product();
            product.setProductId(result.getInt("ProductId"));
            product.setProductName(result.getString("ProductName"));
            product.setProductDescription(result.getString("ProductDescription"));
            product.setPicture(result.getBinaryStream("Picture"));
            product.setPrice(result.getDouble("Price"));
            product.setCategoryId(result.getInt("CategoryId"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql="select * from product where ProductName like'"+productName+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<Product> products=new ArrayList<>();
        while(result.next()){
            Product product = new Product();
            product.setProductId(result.getInt("ProductId"));
            product.setProductName(result.getString("ProductName"));
            product.setProductDescription(result.getString("ProductDescription"));
            product.setPicture(result.getBinaryStream("Picture"));
            product.setPrice(result.getDouble("Price"));
            product.setCategoryId(result.getInt("CategoryId"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {

        Product prs=findById(productId,con);
        String sql="select * from product where ProductName like'"+prs.getProductName()+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<Product> products=new ArrayList<>();
        while(result.next()){
            Product product = new Product();
            product.setProductId(result.getInt("ProductId"));
            product.setProductName(result.getString("ProductName"));
            product.setProductDescription(result.getString("ProductDescription"));
            product.setPicture(result.getBinaryStream("Picture"));
            product.setPrice(result.getDouble("Price"));
            product.setCategoryId(result.getInt("CategoryId"));
            products.add(product);
        }
        return products;

    }
}
