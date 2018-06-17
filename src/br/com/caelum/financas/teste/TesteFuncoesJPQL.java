package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.dao.MovimentacaoDAO;
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
		
//		MovimentacaoDAO dao = new MovimentacaoDAO(em); //usado apartir do momento que transforma o modelo em DAO
//		List<Double> medias = dao .getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		
		
		TypedQuery<Double> typedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = typedQuery.getResultList();
		
		for (Double media : medias) {
			System.out.println("Media do dia : " + medias.get(0));
		}
		
//		BigDecimal soma = (BigDecimal) query.getSingleResult();
//		System.out.println("Soma: " + soma);
//		
//		Double media = (Double) query.getSingleResult();
//		System.out.println("Media: " + media);
		
//		Long quantidade = (Long) query.getSingleResult();
//		System.out.println("Total de Movimentacoes: " + quantidade);
		
		em.getTransaction().commit();
		em.close();
	}

}
