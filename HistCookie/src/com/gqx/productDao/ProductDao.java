package com.gqx.productDao;

import java.util.ArrayList;
import java.util.List;

import com.gqx.entity.Product;

/**
 *该类存放对product的相关操作，如查询、(CRDU)
 * @author Administrator
 *
 */
public class ProductDao {
	//模拟数据库存放所有商品
	private static List<Product> products=new ArrayList<Product>();
	//初始化所有产品，用静态代码块完成，只执行一次
	static{
		for (int i = 1; i < 11; i++) {
				products.add(new Product("00"+i, "笔记本"+i, 4500+i*100, "厂商"+i));	
		}
	}
	
	//提供查询所有商品的方法
	public List<Product> findAll(){
		return this.products;
	}
	
	//根据id去查询某产品
	public Product getProduct(String id){
		for (Product product:products) {
			if (product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}

}
