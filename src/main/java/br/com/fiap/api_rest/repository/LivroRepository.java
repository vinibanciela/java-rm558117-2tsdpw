package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Consultas simples por título
    List<Livro> findByTitulo(String titulo);

    // Consulta com igualdade exata, sem distinguir maiúsculas e minúsculas
    List<Livro> findByTituloEqualsIgnoreCase(String titulo);

    // Consultas para verificar se o ISBN é nulo ou não
    List<Livro> findByIsbnIsNull();
    List<Livro> findByIsbnIsNotNull();

    // Consultas de similaridade (título começa com, autor termina com, autor contém)
    List<Livro> findByTituloStartingWith(String prefix);
    List<Livro> findByAutorEndingWith(String suffix);
    List<Livro> findByAutorContaining(String infix);

    // Usando LIKE para encontrar um padrão no título
    List<Livro> findByTituloLike(String likePattern);

    // Consultas de comparação de valores (preço menor, maior, entre)
    List<Livro> findByPrecoLessThan(double preco);
    List<Livro> findByPrecoGreaterThanEqual(double preco);
    List<Livro> findByPrecoBetween(double min, double max);

    // Consultas de comparação com datas (lançamento antes ou depois de uma data)
    List<Livro> findByDataLancamentoBefore(Date dataLancamento);
    List<Livro> findByDataLancamentoAfter(Date dataLancamento);
    List<Livro> findByDataLancamentoBetween(Date dataLancamentoInicial, Date dataLancamentoFinal);

    // Consultas com múltiplas condições (título ou autor, título ou autor e editora)
    List<Livro> findByTituloOrAutor(String titulo, String autor);
    List<Livro> findByTituloOrAutorAndEditora(String titulo, String autor, String editora);

    // Consultas com múltiplas condições usando AND e OR
    List<Livro> findByTituloAndAutor(String titulo, String autor);
    List<Livro> findByTituloAndAutorOrEditora(String titulo, String autor, String editora);

    // Ordenação dos resultados por título (crescente ou decrescente)
    List<Livro> findByTituloOrderByTituloAsc();
    List<Livro> findByTituloOrderByTituloDesc();

    // Consultas para encontrar os 3 livros mais baratos
    List<Livro> findTop3ByPreco();

    // Consultas usando o operador IN para uma coleção de preços
    List<Livro> findByPrecoIn(Collection<Double> precos);

    // Consultas específicas para booleanos
    List<Livro> findByEbookTrue(); // Livros que são ebooks
    List<Livro> findByEbookFalse(); // Livros que não são ebooks

    // Consultas com Distinct para evitar duplicatas
    List<Livro> findDistinctByAutor(String autor);

    // Consultas usando a palavra-chave "First" ou "Top" para limitar o número de resultados
    List<Livro> findTop5ByPrecoOrderByPrecoAsc(); // Os 5 livros mais baratos, ordenados por preço crescente

    // Consultas usando "First" para pegar o primeiro resultado que corresponde à consulta
    Livro findFirstByTitulo(String titulo); // Retorna o primeiro livro encontrado pelo título

    // Consultas para obter livros com base em condições de "Igualdade" mais legíveis
    List<Livro> findByTituloIs(String titulo); // Usando "Is" para uma consulta igual ao título
    List<Livro> findByTituloIsNot(String titulo); // Usando "IsNot" para uma consulta diferente

    // Consultas com condições "Between" para encontrar livros dentro de um intervalo de preço
    List<Livro> findByPrecoBetweenAndTituloLike(double minPreco, double maxPreco, String likePattern);

    // Consultas com condições de comparação com datas de lançamento
    List<Livro> findByDataLancamentoBefore(Date dataLancamento); // Livros lançados antes de uma data
    List<Livro> findByDataLancamentoAfter(Date dataLancamento); // Livros lançados após uma data
    List<Livro> findByDataLancamentoBetween(Date dataLancamentoInicial, Date dataLancamentoFinal); // Livros lançados entre duas datas
}
