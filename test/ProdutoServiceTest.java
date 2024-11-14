import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

@SpringBootTest
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    public ProdutoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObterProduto() {
        Produto produto = new Produto();
        produto.setId(1L);
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Produto result = produtoService.obterProduto(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto();
        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto result = produtoService.salvarProduto(produto);

        assertNotNull(result);
        verify(produtoRepository, times(1)).save(produto);
    }
}
