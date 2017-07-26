package com.gs.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.gs.bean.Product;
import com.gs.common.WebUtil;
import com.gs.service.ProductService;
import com.gs.service.ProductServiceImpl;

public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 3428951414322189673L;
	
	private ProductService productService;
	
	public ProductServlet() {
		this.productService = new ProductServiceImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		
		if (method.equals("all")) {
			queryAll(req, resp);
		} else if (method.equals("edit_page")) {
			toEditPage(req, resp);
		} else if (method.equals("edit")) {
			edit(req, resp);
		} else if (method.equals("add_page")) {
			toAddPage(req, resp);
		} else if (method.equals("add")) {
			add(req, resp);
		}
	}

	private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = productService.queryAll();
		req.setAttribute("products", products);
		req.getRequestDispatcher("/products.jsp").forward(req, resp);
	}
	
	private void toEditPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String idStr = req.getParameter("id");
		if (idStr != null) {
			try {
				int id = Integer.valueOf(idStr);
				Product p = productService.queryById(id);
				req.setAttribute("product", p);
				req.getRequestDispatcher("/product_edit.jsp").forward(req, resp);
			} catch (NumberFormatException e) {
				resp.sendRedirect("all");
			}
		} else { 
			resp.sendRedirect("all");
		}
	}
	
	private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String idStr = req.getParameter("id");
		String name = req.getParameter("name");
		String priceStr = req.getParameter("price");
		String des = req.getParameter("des");
		float price = 0;
		if (priceStr != null) {
			try {
				price = Float.valueOf(priceStr);
			} catch (NumberFormatException e) {
				
			}
		}
		Product product = new Product();
		product.setId(Integer.valueOf(idStr));
		product.setName(name);
		product.setPrice(price);
		product.setDes(des);
		productService.update(product);
		resp.sendRedirect("all");
	}
	
	private void toAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/product_add.jsp").forward(req, resp);
	}
	
	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		/**
		 * �����Ҫ����ҳ�洫�ݹ������ļ����ݻ�ȡ��������Ҫ������������jar����commons-io, commons-fileupload
		 * 
		 * commons-io��������һЩ��װio����
		 * 
		 * commons-fileupload��װ���ļ��ϴ�����Ҫ�Ĺ���
		 * 
		 * ServletFileUpload����commons-fileupload���ṩ���ļ��ϴ���
		 * 
		 * ����commons-fileupload��˵��jspҳ���е�ÿһ��input,select, checkbox, radio����Ӧһ��FileItem
		 */
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (isMultipart) {
			// ��ʾ��jspҳ��post�����ݰ������ļ����� 
			FileItemFactory fileItemFactory =  new DiskFileItemFactory(); // fileItemFacotry�������ڴ��������input��Ӧ��FileItem����
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			Product product = new Product();
			try {
				List<FileItem> fileItems = fileUpload.parseRequest(req);// ȥ����request���󣬰�ÿһ��FileItem��ȡ��
				for (FileItem fileItem : fileItems) {
					if (fileItem.isFormField()) { // �ж�FileItem�Ƿ�Ϊ��ͨ�ı��ֶ�
						String fieldName = fileItem.getFieldName();// ��ȡ��ͨ���ֶε�nameֵ
						String fieldValue = fileItem.getString();// ��ȡ��ͨ���ֶε�valueֵ
						if (fieldName.equals("name")) {
							product.setName(fieldValue);
						} else if (fieldName.equals("price")) {
							float price = 0;
							try {
							price = Float.valueOf(fieldValue);
							} catch (NumberFormatException e) {
							}
							product.setPrice(price);
						} else if (fieldName.equals("des")) {
							product.setDes(fieldValue);
						}
					} else { // ����Ϊ�ļ��ֶ�
						String fileName = fileItem.getName();// ��ȡ�ļ�������
						// ��Ҫ��ȡͼƬ���ݣ���ͼƬ���浽���ط�������ĳ��Ŀ¼�����·�����浽���ݿ�
						// 1����ȡͼƬ����
						InputStream in = fileItem.getInputStream(); // ��ȡ�ļ�������
						// 2����ͼƬ���ݱ��浽��������ĳ��Ŀ¼��
						String upload = WebUtil.mkUpload(req); // ���������ϴ����ļ���Ŀ¼
						// new File(upload  + "/" + fileItem.getName())   �ϴ����ļ�Ŀ¼ + / + �ļ���
						FileUtils.copyInputStreamToFile(in, new File(upload  + "/" + fileName));
						// 3�����ļ���·�����浽���ݿ�
						product.setImage(WebUtil.DEFAULT_UPLOADS + "/" + fileName);
					}
				}
				productService.add(product);
			} catch (FileUploadException e) {
				e.printStackTrace();
			} 
		} else {
			// ���û���ϴ��ļ�������Ҫ�����ļ��ϴ�
		}
	}

}
