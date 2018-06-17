package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cli = new Cliente();
		cli.setNome("Leonardo");
		cli.setEndereco("Rua Bacururu");
		cli.setProfissao("Analista");
		
		Conta conta = new Conta();
		conta.setId(2);
		cli.setConta(conta);
		
//		Cliente cli2 = new Cliente();
//		cli2.setNome("Rafael");
//		cli2.setEndereco("Rua Flau");
//		cli2.setProfissao("Analista");
//		cli2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cli);
		//em.persist(cli2);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
