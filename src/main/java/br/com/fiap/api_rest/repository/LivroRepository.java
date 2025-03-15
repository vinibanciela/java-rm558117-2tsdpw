package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Consulta simples por título
    List<Livro> findByTitulo(String titulo);

    // Consulta com condição de igualdade (case insensitive)
    List<Livro> findByTituloEqualsIgnoreCase(String titulo);

    // Consulta para encontrar livros cujo ISBN é nulo
    List<Livro> findByIsbnIsNull();

    // Consulta para encontrar livros que não tenham um ISBN
    List<Livro> findByIsbnIsNotNull();

    // Consulta para encontrar livros cujo título começa com "A"
    List<Livro> findByTituloStartingWith(String prefix);

    // Consulta para encontrar livros cujo autor termina com "son"
    List<Livro> findByAutorEndingWith(String suffix);

    // Consulta para encontrar livros cujo nome do autor contenha "Martins"
    List<Livro> findByAutorContaining(String infix);

    // Consulta com o uso de LIKE para buscar um título com o padrão "a%b%c"
    List<Livro> findByTituloLike(String likePattern);

    // Consulta para encontrar livros com preço menor que um valor
    List<Livro> findByPrecoLessThan(double preco);

    // Consulta para encontrar livros com preço maior ou igual a um valor
    List<Livro> findByPrecoGreaterThanEqual(double preco);

    // Consulta para encontrar livros dentro de um intervalo de preços
    List<Livro> findByPrecoBetween(double min, double max);

    // Consulta para encontrar livros lançados antes de uma data
    List<Livro> findByDataLancamentoBefore(Date dataLancamento);

    // Consulta para encontrar livros lançados depois de uma data
    List<Livro> findByDataLancamentoAfter(Date dataLancamento);

    // Consulta para encontrar livros lançados entre duas datas
    List<Livro> findByDataLancamentoBetween(Date dataLancamentoInicial, Date dataLancamentoFinal);

    // Consulta com múltiplas condições, como título ou autor
    List<Livro> findByTituloOrAutor(String titulo, String autor);

    // Consulta com múltiplas condições e ordem de precedência
    List<Livro> findByTituloOrAutorAndEditora(String titulo, String autor, String editora);

    // Consulta para ordenar os livros por título em ordem crescente
    List<Livro> findByTituloOrderByTituloAsc();

    // Consulta para ordenar os livros por título em ordem decrescente
    List<Livro> findByTituloOrderByTituloDesc();

    // Consulta para encontrar os 3 livros mais baratos
    List<Livro> findTop3ByPreco();

    // Consulta para encontrar livros com título igual ao informado e ordenar por preço
    List<Livro> findByTituloOrderByPrecoAsc(String titulo);

    // Consulta para encontrar livros cujo preço esteja dentro de uma lista de valores
    List<Livro> findByPrecoIn(Collection<Double> precos);
}
