let dealerSum = 0;
let yourSum = 0;
let dealerAceCount = 0;
let yourAceCount = 0;
let hidden;
let deck;
let fichas = parseInt(localStorage.getItem("fichas")) || 100;
let aposta; // Adiciona uma variável para armazenar a aposta atual
let canHit = true;

window.onload = function () {
    buildDeck();
    shuffleDeck();
    document.getElementById("fichas").innerText = fichas;

    document.getElementById("place-bet").addEventListener("click", function () {
        aposta = parseInt(document.getElementById("bet").value);
        if (isNaN(aposta) || aposta <= 0 || aposta > fichas) {
            alert("Por favor, insira uma aposta válida!");
        } else {
            fichas -= aposta;
            localStorage.setItem("fichas", fichas);
            document.getElementById("fichas").innerText = fichas;
            startGame();
        }
    });

    document.getElementById("hit").addEventListener("click", hit);
    document.getElementById("stay").addEventListener("click", stay);
};

function buildDeck() {
    let values = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
    let types = ["C", "D", "H", "S"];
    deck = [];
    for (let i = 0; i < types.length; i++) {
        for (let j = 0; j < values.length; j++) {
            deck.push(values[j] + "-" + types[i]);
        }
    }
}

function shuffleDeck() {
    for (let i = 0; i < deck.length; i++) {
        let j = Math.floor(Math.random() * deck.length);
        let temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;
    }
}

function startGame() {
    dealerSum = 0;
    yourSum = 0;
    dealerAceCount = 0;
    yourAceCount = 0;
    hidden = deck.pop();
    dealerSum += getValue(hidden);
    dealerAceCount += checkAce(hidden);

    while (dealerSum < 17) {
        let cardImg = document.createElement("img");
        let card = deck.pop();
        cardImg.src = "./assets/cards/" + card + ".png";
        dealerSum += getValue(card);
        dealerAceCount += checkAce(card);
        document.getElementById("dealer-cards").append(cardImg);
    }

    for (let i = 0; i < 2; i++) {
        let cardImg = document.createElement("img");
        let card = deck.pop();
        cardImg.src = "./assets/cards/" + card + ".png";
        yourSum += getValue(card);
        yourAceCount += checkAce(card);
        document.getElementById("your-cards").append(cardImg);
    }
}

function hit() {
    if (!canHit) {
        return;
    }
    let cardImg = document.createElement("img");
    let card = deck.pop();
    cardImg.src = "./assets/cards/" + card + ".png";
    yourSum += getValue(card);
    yourAceCount += checkAce(card);
    document.getElementById("your-cards").append(cardImg);

    if (reduceAce(yourSum, yourAceCount) > 21) {
        canHit = false;
    }
}

function stay() {
    canHit = false;
    document.getElementById("hidden").src = "./assets/cards/" + hidden + ".png";
    while (dealerSum < 17) {
        let cardImg = document.createElement("img");
        let card = deck.pop();
        cardImg.src = "./assets/cards/" + card + ".png";
        dealerSum += getValue(card);
        dealerAceCount += checkAce(card);
        document.getElementById("dealer-cards").append(cardImg);
    }
    endGame();
}

function endGame() {
    dealerSum = reduceAce(dealerSum, dealerAceCount);
    yourSum = reduceAce(yourSum, yourAceCount);

    let message = "";
    if (yourSum > 21) {
        message = "Você perdeu, atualize a página para jogar de novo.";
    } else if (dealerSum > 21) {
        message = "Você ganhou, atualize a página para jogar de novo.";
        fichas += aposta * 2;
    } else if (yourSum == dealerSum) {
        message = "Empate, atualize a página para jogar de novo.";
        fichas += aposta;
    } else if (yourSum > dealerSum) {
        message = "Você ganhou, atualize a página para jogar de novo.";
        fichas += aposta * 2;
    } else if (yourSum < dealerSum) {
        message = "Você perdeu, atualize a página para jogar de novo.";
    }

    localStorage.setItem("fichas", fichas);
    document.getElementById("fichas").innerText = fichas;

    document.getElementById("your-sum").innerText = yourSum;
    document.getElementById("dealer-sum").innerText = dealerSum;
    document.getElementById("results").innerText = message;

    document.getElementById("hit").removeEventListener("click", hit);
    document.getElementById("stay").removeEventListener("click", stay);

    setTimeout(function () {
        resetGame();
    }, 2000);
}

function resetGame() {
    document.getElementById("dealer-cards").innerHTML = "";
    document.getElementById("your-cards").innerHTML = "";
    dealerSum = 0;
    yourSum = 0;
    dealerAceCount = 0;
    yourAceCount = 0;
    hidden = null;
    canHit = true;
    startGame();
}

function getValue(card) {
    let data = card.split("-");
    let value = data[0];
    if (isNaN(value)) {
        if (value === "A") {
            return 11;
        }
        return 10;
    }
    return parseInt(value);
}

function checkAce(card) {
    if (card[0] === "A") {
        return 1;
    }
    return 0;
}

function reduceAce(playerSum, playerAceCount) {
    while (playerSum > 21 && playerAceCount > 0) {
        playerSum -= 10;
        playerAceCount--;
    }
    return playerSum;
}
