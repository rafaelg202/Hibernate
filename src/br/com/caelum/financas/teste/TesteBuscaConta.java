package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 2);
		
		conta.setTitular("Juca");
		
		em.getTransaction().commit();
		
	}

}
