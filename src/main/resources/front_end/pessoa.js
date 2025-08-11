document.addEventListener("DOMContentLoaded", function () {
    atualizarContador();
});

document.getElementById("cadastroForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const pessoa = {
        nome: document.getElementById("nome").value,
        email: document.getElementById("email").value,
        curso: document.getElementById("curso").value,
        ano: parseInt(document.getElementById("ano").value)
    };

    fetch("http://localhost:8080/api/pessoas", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pessoa)
    })
    .then(response => {
        if (response.ok) {
            document.getElementById("mensagem").textContent = "Cadastro realizado com sucesso!";
            document.getElementById("cadastroForm").reset();
            atualizarContador(); // Atualiza o contador após cadastro
        } else {
            return response.json().then(data => {
                throw new Error(data.mensagem || "Erro ao cadastrar.");
            });
        }
    })
    .catch(error => {
        document.getElementById("mensagem").textContent = error.message;
    });
});

function atualizarContador() {
    fetch("http://localhost:8080/api/pessoas")
        .then(response => response.json())
        .then(data => {
            document.getElementById("contador").textContent = `Pessoas cadastradas: ${data.length}`;
        })
        .catch(error => {
            console.error("Erro ao buscar pessoas:", error);
        });
}
