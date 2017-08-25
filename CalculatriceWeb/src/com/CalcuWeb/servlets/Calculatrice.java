package com.CalcuWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculatrice
 */
@WebServlet("/Calculatrice")
public class Calculatrice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculatrice() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String par1 = request.getParameter("param1");
		String par2 = request.getParameter("param2");
		double param1 = 0;
		double param2 = 0;

		if (!par1.isEmpty())
			param1 = Double.parseDouble(par1);
		if (!par2.isEmpty())
			param2 = Double.parseDouble(par2);

		String op = request.getParameter("operation");

		double res = 0;
		try {
			res = calcul(param1, param2, op);
			request.setAttribute("response", "la reponse est " +par1 +" " +op +" "+par2+" = "+ res);
		} catch (ArithmeticException e) {
			request.setAttribute("error", "Division par zéro interdite");
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
	}

	public double calcul(double p1, double p2, String op) {
		double res;
		switch (op) {
		case "+":
			res = p1 + p2;
			break;
		case "-":
			res = p1 - p2;
			break;
		case "*":
			res = p1 * p2;
			break;
		case "/":
			if (p2 == 0)
				throw new ArithmeticException();
			res = p1 / p2;
			break;
		default:
			res = 0;
			break;
		}
		return res;
	}

}
