package com.gs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.gs.bean.Product;
import com.gs.common.bean.ControllerResult;
import com.gs.common.bean.Pager4EasyUI;
import com.gs.service.ProductService;
import com.gs.service.ProductServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -2837543750268792387L;
	
	private ProductService productService;
	private Product product;
	private int total; // ���ظ�easyui����ҳ��
	private List<Product> rows; // ���ظ�easyui�Ľ��
	private ControllerResult result;
	
	private String id;
	private String ids;
	
	private HttpServletRequest req;
	
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}
	
	public ProductAction() {
		productService = new ProductServiceImpl();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getTotal() {
		return total;
	}

	public List<Product> getRows() {
		return rows;
	}

	public ControllerResult getResult() {
		return result;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setIds(String ids) {
		this.ids = ids;
	}

	public String add() {
		productService.add(product);
		result = ControllerResult.getSuccessResult("��ӳɹ�");
		return "add";
	}
	
	public String queryById() {
		product = productService.queryById(id);
		return "query";
	}
	
	public String queryAll() {
		String pageNoStr = req.getParameter("page");
		String pageSizeStr = req.getParameter("rows");
		Pager4EasyUI<Product> pager = new Pager4EasyUI<Product>();
		if (pageNoStr !=null) {
			pager.setPageNo(Integer.valueOf(pageNoStr));
			pager.setPageSize(Integer.valueOf(pageSizeStr));
		}
		pager = productService.queryAll(pager);
		rows = pager.getRows();
		total = pager.getTotal();
		return "all";
	}
	
	public String update() {
		productService.update(product);
		result = ControllerResult.getSuccessResult("���³ɹ�");
		return "update";
	}
	
	public String deleteByIds() {
		productService.deleteByIds(ids.split(","));
		result = ControllerResult.getSuccessResult("ɾ���ɹ�");
		return "delete";
	}

}
