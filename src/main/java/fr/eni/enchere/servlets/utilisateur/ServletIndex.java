package fr.eni.enchere.servlets.utilisateur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bo.CategorieBO;
import fr.eni.enchere.bo.EnchereBO;

/**
 * Servlet implementation class ServletIndex
 */
//@WebServlet("/")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static CategorieManager categories = new CategorieManager();
    private static EnchereManager encheres = new EnchereManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategorieBO> cats = categories.getAllCategorie();
		request.setAttribute("categorieList", cats);
		System.out.println("cc enchere");
		List<EnchereBO> enchereList = encheres.getAllEnchere();
		
		request.setAttribute("enchereList", enchereList);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategorieBO> cats = categories.getAllCategorie();
		System.out.println("zzzzzzzzzz");
		for (CategorieBO categorieBO : cats) {
			System.out.println(categorieBO.getLibelle());
		}
		request.setAttribute("categorieList", cats);  
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
