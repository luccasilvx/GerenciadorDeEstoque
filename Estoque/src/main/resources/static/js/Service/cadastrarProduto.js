document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".form");

    form.addEventListener("submit", async function (event) {
        event.preventDefault();

        const nome = document.getElementById("nome").value.trim();
        const descricao = document.getElementById("descricao").value.trim();
        const preco = document.getElementById("preco").value.trim();

        if (!nome || !descricao || !preco) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        const produto = {
            nome: nome,
            descricao: descricao,
            preco: parseFloat(preco) // Convertendo string para número
        };

        try {
            const response = await fetch("http://localhost:8080/api/produtos", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(produto)
            });

            if (!response.ok) {
                throw new Error("Erro ao cadastrar produto.");
            }

            const data = await response.json();
            alert(`Produto "${data.nomeProduto}" cadastrado com sucesso!`);

            form.reset();
        } catch (error) {
            console.error("Erro:", error);
            alert("Ocorreu um erro ao cadastrar o produto.");
        }
    });
});
