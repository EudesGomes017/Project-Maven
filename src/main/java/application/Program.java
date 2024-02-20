package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {

		/*
		 * Person p1 = new Person(null, "Carlos da Silva", "carlos@gmail.com"); Person
		 * p2 = new Person(null, "Joaquim Torres", "joaquim@gmail.com"); Person p3 = new
		 * Person(null, "Ana Maria", "ana@gmail.com");
		 * 
		 * 
		 * EntityManagerFactory emf =
		 * Persistence.createEntityManagerFactory("exemplo-jpa"); EntityManager em =
		 * emf.createEntityManager();
		 * 
		 * em.getTransaction().begin();
		 * 
		 * em.persist(p1); em.persist(p2); em.persist(p3);
		 * 
		 * em.getTransaction().commit(); System.out.println("Pronto"); em.close();
		 * emf.close();
		 */

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		// Person p = em.find(Person.class, 2);

		// o jpa so consegui remover uma entidade quando esta monitorada, ele faz essa
		// diferenciação
		// Objeto monitorado é quando acabomos de inserir ou é objeto que buscamos no
		// banco de dados e não foi fechado o EntityManager

		// sempre que a uma operação que não seja um simples consultas temos que por a
		// transação
		em.getTransaction().begin();

		Person p = em.find(Person.class, 2);
		em.remove(p);
		em.getTransaction().commit();

		System.out.println();

		System.out.println("Pronto");
		em.close();
		emf.close();

	}

	/*
	 * Criação do EntityManager e EntityManagerFactory:
	 * 
	 * Aqui, o código cria um EntityManagerFactory com base na configuração nomeada
	 * "exemplo-jpa" definida no arquivo de configuração persistence.xml. Em
	 * seguida, um EntityManager é criado a partir do EntityManagerFactory.
	 * 
	 * Remoção de uma entidade do banco de dados:
	 * 
	 */

	/*
	 * O método getTransaction().begin() é utilizado para iniciar uma transação no
	 * contexto do EntityManager no contexto do JPA (Java Persistence API). Vou
	 * explicar cada parte:
	 * 
	 * em: é uma instância do EntityManager, que é uma interface no JPA usada para
	 * realizar operações de persistência, como salvar, atualizar, recuperar e
	 * excluir entidades no banco de dados.
	 * 
	 * getTransaction(): é um método do EntityManager que retorna um objeto
	 * representando a transação atual. Este objeto geralmente implementa a
	 * interface EntityTransaction, que fornece métodos para controlar o início, fim
	 * e estado da transação.
	 * 
	 * begin(): é um método do objeto de transação retornado por getTransaction().
	 * Ele inicia uma nova transação. Isso significa que quaisquer operações de
	 * persistência realizadas após chamar este método serão agrupadas em uma única
	 * transação, que pode ser confirmada (commit) ou revertida (rollback)
	 * posteriormente.
	 * 
	 * Quando você inicia uma transação usando getTransaction().begin(), está
	 * indicando ao EntityManager que está prestes a realizar uma série de operações
	 * de persistência que devem ser tratadas como uma única unidade atômica de
	 * trabalho. Isso é importante porque garante que todas as operações de
	 * persistência dentro da transação sejam tratadas de forma consistente, ou
	 * seja, ou todas são aplicadas (comitadas) ou nenhuma é aplicada (rollback).
	 * Isso ajuda a manter a integridade e a consistência dos dados no banco de
	 * dados.
	 * 
	 * Em resumo, em.getTransaction().begin() inicia uma nova transação no contexto
	 * do EntityManager, permitindo que você agrupe operações de persistência
	 * relacionadas em uma única unidade atômica de trabalho.
	 */

}
