document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".form");

    form.addEventListener("submit", async function (event) {
        event.preventDefault();

        const numeroProduto = document.getElementById("numero").value.trim();

        if (!numeroProduto) {
            alert("Por favor, informe o número do produto.");
            return;
        }

        const confirmar = confirm(`Tem certeza que deseja remover o produto ${numeroProduto}?`);
        if (!confirmar) return;

        try {
            const response = await fetch(`http://localhost:8081/api/produtos/${numeroProduto}`, {
                method: "DELETE",
            });

            if (!response.ok) {
                throw new Error("Erro ao remover o produto.");
            }

            alert(`Produto ${numeroProduto} removido com sucesso!`);
            form.reset();

        } catch (error) {
            console.error("Erro:", error);
            alert("Ocorreu um erro ao remover o produto.");
        }
    });
});
