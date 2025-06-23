private ArrayList<Cliente> clientesQueCompraram = new ArrayList<>();

public void adicionarCliente(Cliente cliente) {
    if (cliente != null && !clientesQueCompraram.contains(cliente)) {
        clientesQueCompraram.add(cliente);
    }
}

public ArrayList<Cliente> getClientesQueCompraram() {
    return clientesQueCompraram;
}
