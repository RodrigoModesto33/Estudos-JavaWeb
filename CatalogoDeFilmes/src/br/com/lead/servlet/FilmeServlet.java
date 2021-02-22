package br.com.lead.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import br.com.lead.model.Filme;

@WebServlet("/filme")
public class FilmeServlet extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	Filme coringa = new Filme("Coringa", "Drama", 2019);
	Filme matrix= new Filme("Matrix", "Ação", 1991);
	Filme forestGump = new Filme("Forest Gump", "Drama", 1994);
	
	ArrayList<Filme> filmes = new ArrayList<Filme>();
	filmes.add(coringa);
	filmes.add(matrix);
	filmes.add(forestGump);
	
	String genero = req.getParameter("genero");
	
	res.setContentType("text/HTML");
	PrintWriter out = res.getWriter();
	
	out.println("<h2>Lista de filmes utilizando servlets</h2>");
	out.println("<ol>");
	
	ArrayList<Filme> listaFiltrada = filmes.stream().filter(filme -> filme.getGenero().equalsIgnoreCase(genero)).collect(Collectors.toCollection(ArrayList::new));
	
	req.setAttribute("listaFiltrada", listaFiltrada);
	
	RequestDispatcher dispacher = req.getRequestDispatcher("lista-filmes.jsp");
	dispacher.forward(req, res);
	}
}
