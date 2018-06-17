package br.com.caelum.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TesteMovimentacoesCategoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Movimentacao mvt1 = new Movimentacao();
		mvt1.setData(Calendar.getInstance());
		mvt1.setDescricao("Viagem à SP");
		mvt1.setTipo(TipoMovimentacao.SAIDA);
		mvt1.setValor(new BigDecimal("1300.0"));
		mvt1.setCategoria(Arrays.asList(categoria1,categoria2));
		
		mvt1.setConta(conta);
		
		Movimentacao mvt2 = new Movimentacao();
		
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		mvt2.setData(amanha);
		mvt2.setDescricao("Viagem à RJ");
		mvt2.setTipo(TipoMovimentacao.SAIDA);
		mvt2.setValor(new BigDecimal("500.0"));
		mvt2.setCategoria(Arrays.asList(categoria1,categoria2));
		
		mvt2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(mvt1);
		em.persist(mvt2);
		
		em.getTransaction().commit();
		em.close();
	}

}
