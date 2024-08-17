package dao;

import domain.Produto;
import persistence.JPAUtil;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {

    private JPAUtil jpaUtil;

    public ProdutoDAO(){
        jpaUtil = new JPAUtil();
    };

    public void save(Produto produto){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(produto);
        jpaUtil.getEntityManager().getTransaction().commit();
//        jpaUtil.getEntityManager().flush();
    }


    public Produto getById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        Produto produto = jpaUtil.getEntityManager().find(Produto.class, id);

        return produto;
    }
    public List<Produto> getAllProdutos(){

        //utilizando jpql
        jpaUtil.getEntityManager().getTransaction().begin();
        // String jpql = "select p from Produto p";
        var query = jpaUtil.getEntityManager()
                .createNamedQuery("produto.getAll");
        return query.getResultList();
    }

    public List<Produto> getAllProdutosByPreco(BigDecimal valor){

        //utilizando jpql
        jpaUtil.getEntityManager().getTransaction().begin();
        // String jpql = "select p from Produto p";
        var query = jpaUtil.getEntityManager()
                .createNamedQuery("produto.byPrice");
        query.setParameter("preco", valor);
        return query.getResultList();
    }

    public Produto findByName(String nome){
        jpaUtil.getEntityManager().getTransaction().begin();
        Query query = jpaUtil.getEntityManager()
                .createNamedQuery("produto.byName");
        query.setParameter("nome",nome);
        return (Produto) query.getSingleResult();
    }
    public List<Produto> findByNameLike(String nome){
        jpaUtil.getEntityManager().getTransaction().begin();
        Query query = jpaUtil.getEntityManager()
                .createNamedQuery("produto.byNameLike");
        query.setParameter("nome", "%"+nome+"%");
        return query.getResultList();
    }

}
