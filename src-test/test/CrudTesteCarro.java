package test;

import junit.framework.TestCase;

import model.Carro;
import service.CarroService;



import java.util.List;

import org.junit.Test;



public class CrudTesteCarro extends TestCase {

	@Test
	public void testListarCarro() {
		List<Carro> carros = atualizar().getCarros();
		assertNotNull(carros);
		// verifica se tem algum erro na lista
		assertTrue(carros.size() > 0);
		// validar se entreou caminhao
		Carro caminhao = atualizar().findByName("Tucker 1948").get(0);
		assertEquals("Tucker 1948", caminhao.getNome());
		// verifica se ferrari entrou
		Carro ferrari = atualizar().findByName("Chevrolet Impala Coupe").get(0);
		assertEquals("Chevrolet Impala Coupe", ferrari.getNome());
		// verifica se fusca entrou
		Carro fusca = atualizar().findByName("Chevrolet Corvette").get(0);
		assertEquals("Chevrolet Corvette", fusca.getNome());
	}
private CarroService atualizar() {
	CarroService carroService = new CarroService();
	return carroService;
}
}
