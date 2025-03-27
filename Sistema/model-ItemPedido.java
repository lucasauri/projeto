model/ItemPedido.javapackage com.hortifruti.model;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private String embalagem;
    private String produto;
    private int quantidade;
    private int totalMudas;
    private Double preco;
    private Double total;

    // Getters e Setters
}
