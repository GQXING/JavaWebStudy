package com.gqx.productDao;

import java.util.ArrayList;
import java.util.List;

import com.gqx.entity.Product;

/**
 *�����Ŷ�product����ز��������ѯ��(CRDU)
 * @author Administrator
 *
 */
public class ProductDao {
	//ģ�����ݿ���������Ʒ
	private static List<Product> products=new ArrayList<Product>();
	//��ʼ�����в�Ʒ���þ�̬�������ɣ�ִֻ��һ��
	static{
		for (int i = 1; i < 11; i++) {
				products.add(new Product("00"+i, "�ʼǱ�"+i, 4500+i*100, "����"+i));	
		}
	}
	
	//�ṩ��ѯ������Ʒ�ķ���
	public List<Product> findAll(){
		return this.products;
	}
	
	//����idȥ��ѯĳ��Ʒ
	public Product getProduct(String id){
		for (Product product:products) {
			if (product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}

}
