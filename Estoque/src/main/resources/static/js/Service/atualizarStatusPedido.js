document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('.form');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const numeroPedido = document.getElementById('pedido').value;
        const status = document.getElementById('status').value;

        if (!numeroPedido || !status) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        const url = `http://localhost:8081/api/pedido/${numeroPedido}/status`;
        const data = {
            status: status
        };

        fetch(url, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Falha na atualização do status do pedido');
            }
            return response.json();
        })
        .then(data => {
            alert('Status do pedido atualizado com sucesso!');
            console.log(data);
        })
        .catch(error => {
            alert('Erro ao atualizar o status do pedido: ' + error.message);
        });
    });
});
