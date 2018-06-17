package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager em;
	
	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
		// TODO Auto-generated method stub
		String jpql = "SELECT distinct AVG(m.valor) FROM Movimentacao m WHERE m.conta = :pConta" + // SUM(m.valor) retorna BigDecimal || AVG(m.valor) retorna Double
				" AND m.tipo = :pTipo " +
				" GROUP BY  m.data " ;
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
	 
		return query.getResultList();
	}
	
}
