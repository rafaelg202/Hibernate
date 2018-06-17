package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "SELECT COUNT(m.valor) FROM Movimentacao m WHERE m.conta = :pConta" + // SUM(m.valor) retorna BigDecimal || AVG(m.valor) retorna Double
				" AND m.tipo = :pTipo " +	
				" ORDER BY m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
//		BigDecimal soma = (BigDecimal) query.getSingleResult();
//		System.out.println("Soma: " + soma);
//		
//		Double media = (Double) query.getSingleResult();
//		System.out.println("Media: " + media);
		
		Long quantidade = (Long) query.getSingleResult();
		System.out.println("Total de Movimentacoes: " + quantidade);
		
		em.getTransaction().commit();
		em.close();
	}

}
