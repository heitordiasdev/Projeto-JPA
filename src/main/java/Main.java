import dao.ProdutoDAO;
import domain.Produto;
import lombok.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Produto produto1 = Produto.builder()
                .categoria("Frios")
                .descricao("Peito de Frango 1KG")
                .nome("Peito de Frango")
                .disponivel(true)
                .preco(BigDecimal.valueOf(30)).build();

        ProdutoDAO produtoDAO1 = new ProdutoDAO();
//        produtoDAO1.save(produto1);

//
//        System.out.println(produtoDAO1.getById(1l));
//        System.out.println(produtoDAO1.findByName("Peito de Frango"));
        System.out.println(produtoDAO1.findByNameLike("Ave"));
    }
}
