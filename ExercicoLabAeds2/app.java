private static Pedido pedidoComItensAleatorios() {
    Pedido pedido = new Pedido();
    Random random = new Random();

    // Seleciona um cliente aleatório
    int posicaoCliente = random.nextInt(clientes.size());
    Cliente cliente = clientes.get(posicaoCliente);

    // Adiciona pedido ao cliente
    cliente.adicionarPedido(pedido);

    // Adiciona itens ao pedido
    int quantidadeItens = 1 + random.nextInt(5);
    for (int i = 0; i < quantidadeItens; i++) {
        Produto produto = produtosPorId.getAleatorio();
        if (produto != null) {
            pedido.adicionarItem(produto);

            // Associa o pedido ao produto
            produto.adicionarPedido(pedido);

            // Associa o cliente ao produto
            produto.adicionarCliente(cliente);
        }
    }

    return pedido;
}
