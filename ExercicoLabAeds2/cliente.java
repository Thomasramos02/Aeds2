import java.util.ArrayList;

public class Cliente {
    private String documento;
    private String nome;
    private ArrayList<Pedido> pedidos;

    public Cliente(String documento, String nome) {
        this.documento = documento;
        this.nome = nome;
        this.pedidos = new ArrayList<>();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedido != null) {
            pedidos.add(pedido);
        }
    }

    public double totalGasto() {
        double total = 0.0;
        for (Pedido pedido : pedidos) {
            total += pedido.getValorTotal();
        }
        return total;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", totalPedidos=" + pedidos.size() +
                '}';
    }
}
