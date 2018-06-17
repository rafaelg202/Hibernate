package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conta conta = new Conta();
		conta.setAgencia("0102");
		conta.setBanco("Itau");
		conta.setNumero("12345");
		conta.setTitular("Rafael");
		
		Movimentacao mvt = new Movimentacao();
		mvt.setData(Calendar.getInstance());
		mvt.setDescricao("churrascaria");
		mvt.setTipo(TipoMovimentacao.SAIDA);
		mvt.setValor(new BigDecimal("200.0"));
		
		mvt.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(mvt);
		
		em.getTransaction().commit();
		em.close();
	}

}
