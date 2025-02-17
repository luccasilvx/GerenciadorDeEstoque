document.addEventListener("DOMContentLoaded", function () {
    carregarProdutos();
});

function carregarProdutos() {
    fetch("http://localhost:8081/api/produtos") // Altere para a URL correta da sua API
        .then(response => response.json())
        .then(produtos => {
            const tabela = document.getElementById("listaProdutos");
            tabela.innerHTML = ""; // Limpa a tabela antes de inserir os dados

            produtos.forEach(produto => {
                let row = `
                    <tr>
                        <td>${produto.numeroProduto}</td>
                        <td>${produto.nomeProduto}</td>
                        <td>${produto.descricao}</td>
                        <td>R$ ${produto.preco.toFixed(2)}</td>
                    </tr>
                `;
                tabela.innerHTML += row;
            });
        })
        .catch(error => console.error("Erro ao carregar produtos:", error));
}
