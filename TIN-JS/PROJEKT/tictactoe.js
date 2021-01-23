//pobranie elementow board__item do nodelisty
const fieldsElements = document.querySelectorAll(".board__item");

//pobranie elementow board__item do nodelisty
const panel = document.querySelector(".panel");

//pobranie elementow board__item do nodelisty
const resetButton = document.querySelector(".reset-button");

//wybrane pola
let fields;
let currentPlayer;
let gameActive;

const resetGame = () => {
    fields = ["","","","","","","","",""];
    currentPlayer = "X";
    gameActive = true;
}

resetGame();

const winningConditions = [
    [0,1,2],
    [3,4,5],
    [6,7,8],
    [0,3,6],
    [1,4,7],
    [2,5,8],
    [0,4,8],
    [2,4,6]
];

const displayWinnerMessage = () => {
    panel.innerHTML = `Wygrał ${currentPlayer}!`;
};

const displayTieMessage = () => {
    panel.innerHTML = `Remis!`;
};

const clearMessage = () => {
    panel.innerHTML = '';
};

const checkWinningCondition = () => {
    let gameWon = false;

    for (let i = 0; i <= 7; i++){
        const [posA, posB, posC] = winningConditions[i];
        const value1 = fields[posA];
        const value2 = fields[posB];
        const value3 = fields[posC];

        if (value1 !== "" && value1 === value2 && value1 === value3){
            gameWon = true;;
            displayWinnerMessage();
        }
    }
    
    if (gameWon){
        gameActive = false;
        displayWinnerMessage();
    }
    else if (isBoardFull()){
        displayTieMessage();
    }
};

const isBoardFull = () => {
    return fields.find(field => field === "") === undefined;
};

//callback do pojedynczego pola
fieldsElements.forEach(field => {
    field.addEventListener("click", event => {
        const { pos } = event.target.dataset;

        if (gameActive && fields[pos] === ""){
            fields[pos] = currentPlayer;
            event.target.classList.add(`board__item--filled-${currentPlayer}`);
            
            checkWinningCondition();
            
            currentPlayer = currentPlayer === "X" ? "O" : "X";
        }
    });
});

const resetBoardClassed = () => {
    fieldsElements.forEach(field => {
        field.classList.remove("board__item--filled-X", "board__item--filled-O")
    });
};

const handleButtonClick = () => {
    resetGame();
    resetBoardClassed();
    clearMessage();
};

resetButton.addEventListener('click', handleButtonClick);