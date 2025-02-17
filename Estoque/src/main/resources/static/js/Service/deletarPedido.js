document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".form");

    form.addEventListener("submit", async function (event) {
        event.preventDefault();

        const numeroPedido = document.getElementById("pedido").value.trim();

        if (!numeroPedido) {
            alert("Por favor, informe o número do pedido.");
            return;
        }

        const confirmar = confirm(`Tem certeza que deseja cancelar o pedido ${numeroPedido}?`);
        if (!confirmar) return;

        try {
            const response = await fetch(`http://localhost:8081/api/pedido/${numeroPedido}`, {
                method: "DELETE",
            });

            if (!response.ok) {
                throw new Error("Erro ao cancelar o pedido.");
            }

            alert(`Pedido ${numeroPedido} cancelado com sucesso!`);
            form.reset();

        } catch (error) {
            console.error("Erro:", error);
            alert("Ocorreu um erro ao cancelar o pedido.");
        }
    });
});
