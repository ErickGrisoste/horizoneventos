document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("formCadastro").addEventListener("submit", async function (event) {
        event.preventDefault(); // Evita recarregar a página

        // Captura os valores dos inputs
        let nome = document.getElementById("nome").value;
        let email = document.getElementById("email").value;
        let senha = document.getElementById("senha").value;

        // Cria um objeto para enviar no body da requisição
        let usuario = {
            nome: nome,
            email: email,
            senha: senha
        };

        try {
            // Faz a requisição para a API
            let response = await fetch("http://localhost:8080/auth/registrar", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(usuario)
            });

            if (response.ok) {
                alert("Usuário cadastrado com sucesso!");
            } else {
                alert("Erro ao cadastrar usuário.");
            }
        } catch (error) {
            console.error("Erro na requisição:", error);
            alert("Erro ao conectar com o servidor.");
        }
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("loginForm");

    form.addEventListener("submit", async function (e) {
        e.preventDefault();

        const email = document.getElementById("email").value;
        const senha = document.getElementById("senha").value;

        const loginData = {
            email: email,
            senha: senha
        };

        try {
            const response = await fetch("http://localhost:8080/auth/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(loginData)
            });

            const sucesso = await response.json();

            if (sucesso) {
                alert("Login bem-sucedido!");
                window.location.href = "eventos.html";
            } else {
                alert("Email ou senha incorretos.");
            }
        } catch (error) {
            console.error("Erro ao fazer login:", error);
            alert("Erro ao conectar com o servidor.");
        }
    });
});
