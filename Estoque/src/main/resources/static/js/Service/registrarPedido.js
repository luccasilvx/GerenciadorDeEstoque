document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('.form');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const nome = document.getElementById('nome').value;
        const email = document.getElementById('email').value;
        const produto = document.getElementById('produto').value;
        const quantidade = document.getElementById('quantidade').value;

        if (!nome || !email || !produto || !quantidade) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        const url = 'http://localhost:8081/api/pedido';
        const data = {
            nome: nome,
            email: email,
            produto: produto,
            quantidade: quantidade
        };

        fetch(url, {
            method: 'POST', // Método HTTP POST
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Falha ao criar o pedido');
            }
            return response.json();
        })
        .then(data => {
            alert('Pedido criado com sucesso!');
            console.log(data);
        })
        .catch(error => {
            alert('Erro ao criar o pedido: ' + error.message);
        });
    });
});
