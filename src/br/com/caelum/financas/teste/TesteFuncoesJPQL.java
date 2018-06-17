package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		
		String jpql = "SELECT distinct AVG(m.valor) FROM Movimentacao m WHERE m.conta = :pConta" + // SUM(m.valor) retorna BigDecimal || AVG(m.valor) retorna Double
				" AND m.tipo = :pTipo " +
				" GROUP BY  m.data " ;
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
//		BigDecimal soma = (BigDecimal) query.getSingleResult();
//		System.out.println("Soma: " + soma);
//		
//		Double media = (Double) query.getSingleResult();
//		System.out.println("Media: " + media);
		
		List <Double> medias = query.getResultList();
		
		for (Double media : medias) {
			System.out.println("Media do dia : " + medias.get(0));
		}
		
//		Long quantidade = (Long) query.getSingleResult();
//		System.out.println("Total de Movimentacoes: " + quantidade);
		
		em.getTransaction().commit();
		em.close();
	}

}
