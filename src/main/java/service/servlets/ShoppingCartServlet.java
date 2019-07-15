package main.java.service.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Product;
import main.java.model.exceptions.ProcessException;
import main.java.service.dao.ProductDAO;

@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionMode = request.getParameter("action-mode");
		if (actionMode == null || actionMode.trim().equals("")) {
			throw new ProcessException("Action is not identify");
		} else {
			if (actionMode.equals("add")) {
				addToCart(request, response);
			}
			if (actionMode.equals("goToCart")) {
				goToCart(request, response);
			}
			if (actionMode.equals("remove")) {
				removeFromCart(request, response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			throw new ProcessException("You must login for shopping cart");
		}
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Product> sessionProductList = (ArrayList<Product>) request.getSession().getAttribute("productList");
		ProductDAO productDao = new ProductDAO();
		String productIdSt = request.getParameter("product-id");
		if (productIdSt != null && (!productIdSt.trim().equals("")) && productIdSt.matches("\\d+")) {
			Product selectedProduct = productDao.findProductById(Integer.parseInt(productIdSt));
			if (sessionProductList != null) {
				sessionProductList.add(selectedProduct);
				request.getSession().setAttribute("productList", sessionProductList);
			} else {
				productList.add(selectedProduct);
				request.getSession().setAttribute("productList", productList);
			}

		} else {
			throw new ProcessException("Product id is not identify");
		}

		request.setAttribute("productList", productDao.showAllProducts());
		request.getRequestDispatcher("/jsps/product.jsp").forward(request, response);
	}

	private void goToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			throw new ProcessException("You must login for shopping cart");
		}
		float totalCost = 0;
		List<Product> productList = (List<Product>) request.getSession().getAttribute("productList");
		if (productList != null) {
			for (Product productItem : productList) {
				totalCost = productItem.getCost() + totalCost;
			}
		}
		request.setAttribute("cartProductList", productList);
		request.setAttribute("totalCost", totalCost);
		request.getRequestDispatcher("/jsps/shoppingCart.jsp").forward(request, response);

	}

	private void removeFromCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		float totalCost = 0;
		String productIdSt = request.getParameter("product-id");
		ProductDAO productDAO = new ProductDAO();
		List<Product> sessionProductList = (List<Product>) request.getSession().getAttribute("productList");
		if (productIdSt != null && (!productIdSt.trim().equals("")) && productIdSt.matches("\\d+")) {
			sessionProductList.remove(productDAO.findProductById(Integer.parseInt(productIdSt)));
		}
		request.getSession().setAttribute("cartProductList", sessionProductList);
		if (sessionProductList != null) {
			for (Product productItem : sessionProductList) {
				totalCost = productItem.getCost() + totalCost;
			}
		}
		request.setAttribute("cartProductList", sessionProductList);
		request.setAttribute("totalCost", totalCost);
		request.getRequestDispatcher("/jsps/shoppingCart.jsp").forward(request, response);

	}
}
