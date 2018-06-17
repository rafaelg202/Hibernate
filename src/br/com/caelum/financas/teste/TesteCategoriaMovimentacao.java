package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteCategoriaMovimentacao {
	
	public static void main(String[] args){
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	
	Categoria cat = new Categoria();
	cat.setId(2);
	
	String jpql = "SELECT m FROM Movimentacao m join m.categoria c WHERE c = :pCategoria";
	Query query = em.createQuery(jpql);
	query.setParameter("pCategoria", cat);

	
	List<Movimentacao> resultados = query.getResultList();
	
	for (Movimentacao movimentacao : resultados) {
		System.out.println("Descrição: " + movimentacao.getDescricao());
		System.out.println("Conta id: " + movimentacao.getId());
	}
	
	em.getTransaction().commit();
	em.close();
	}
}
