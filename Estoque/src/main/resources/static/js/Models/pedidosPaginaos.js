let paginaAtual = 0;
const itensPorPagina = 10;

document.addEventListener("DOMContentLoaded", () => {
    carregarPedidos(paginaAtual);

    document.getElementById("btnAnterior").addEventListener("click", () => {
        if (paginaAtual > 0) {
            paginaAtual--;
            carregarPedidos(paginaAtual);
        }
    });

    document.getElementById("btnProximo").addEventListener("click", () => {
        paginaAtual++;
        carregarPedidos(paginaAtual);
    });
});

async function carregarPedidos(pagina) {
    try {
        const response = await fetch(`/api/pedido?pagina=${pagina}&itens=${itensPorPagina}`);
        const data = await response.json();

        atualizarTabela(data.content);
        atualizarBotoes(data);
    } catch (error) {
        console.error("Erro ao carregar pedidos:", error);
    }
}

function atualizarTabela(pedidos) {
    const tabela = document.getElementById("tabelaPedidos");
    tabela.innerHTML = "";

    pedidos.forEach(pedido => {
        const row = `<tr>
            <td>${pedido.numeroPedido}</td>
            <td>${pedido.clienteNome}</td>
            <td>${pedido.produto.descricao}</td>
            <td>${new Date(pedido.dataPedido).toLocaleDateString()}</td>
            <td>${pedido.status}</td>
        </tr>`;
        tabela.innerHTML += row;
    });
}

function atualizarBotoes(data) {
    document.getElementById("paginaAtual").textContent = data.number + 1;
    document.getElementById("btnAnterior").disabled = data.first;
    document.getElementById("btnProximo").disabled = data.last;
}
