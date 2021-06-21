
import com.google.gson.Gson;


import model.Carro;
import service.CarroService;

public class teste {

	public static void main(String[] args) {
		CarroService carro = new CarroService();
		Gson gson = new Gson();
		Carro c = new Carro();
        c.setId(34L);
		c.setNome("Laiane andrade");
		c.setDesc("Descrição Tucker 1948");
		c.setUrlFoto("http://www.livroandroid.com.br/livro/carros/classicos/Tucker.png");
		c.setUrlVideo("http://www.livroandroid.com.br/livro/carros/classicos/tucker.mp4");
		c.setLatitude("-23.564224");
		c.setLongitude("-46.653156");
		c.setTipo("classicos");
		System.out.println(gson.toJson(carro.delete(34L)));
		// carro.update(c);
		// carro.delete(31L);
	}
}
