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
private static void relatorioDeCliente() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Informe o documento do cliente: ");
    String documento = scanner.nextLine();

    Cliente clienteEncontrado = null;
    for (Cliente c : clientes) {
        if (c.getDocumento().equals(documento)) {
            clienteEncontrado = c;
            break;
        }
    }

    if (clienteEncontrado == null) {
        System.out.println("Cliente não encontrado.");
        return;
    }

    System.out.println("Relatório do Cliente: " + clienteEncontrado.getNome() + " (Documento: " + clienteEncontrado.getDocumento() + ")");
    System.out.println("Pedidos realizados:");

    for (Pedido pedido : clienteEncontrado.getPedidos()) {
        System.out.println(pedido);
    }

    System.out.printf("Total gasto: R$ %.2f\n", clienteEncontrado.totalGasto());
}
private static void clientesPorProduto() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Informe o ID do produto: ");
    int idProduto = scanner.nextInt();

    Produto produto = produtosPorId.buscar(idProduto);

    if (produto == null) {
        System.out.println("Produto não encontrado.");
        return;
    }

    ArrayList<Cliente> listaClientes = produto.getClientesQueCompraram();

    if (listaClientes.isEmpty()) {
        System.out.println("Nenhum cliente comprou este produto ainda.");
        return;
    }

    System.out.println("Clientes que compraram o produto " + produto.getNome() + " (ID: " + produto.getId() + "):");

    for (Cliente cliente : listaClientes) {
        System.out.println("Nome: " + cliente.getNome() + " | Documento: " + cliente.getDocumento());
    }
}
case 6:
    relatorioDeCliente();
    break;
case 7:
    clientesPorProduto();
    break;
