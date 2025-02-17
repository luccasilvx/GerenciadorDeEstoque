document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".form");

    form.addEventListener("submit", async function (event) {
        event.preventDefault();

        try {
            const response = await fetch("http://localhost:8081/api/pedido/relatorio", {
                method: "GET",
            });

            if (!response.ok) {
                throw new Error("Erro ao gerar o relatório.");
            }

            const relatorio = await response.json();


            console.log("Relatório gerado:", relatorio);
            alert("Relatório gerado com sucesso! Confira no console.");

        } catch (error) {
            console.error("Erro:", error);
            alert("Ocorreu um erro ao gerar o relatório.");
        }
    });
});
