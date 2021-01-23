let a = 3;

function printMultiplicationTable(a){
    for (let i = 1; i <= a; i++){
        console.log("Mnozenie przez " + i);
        for (let j = 1; j <= a; j++){
            result = i + " * " + j + " = " + i*j;
            console.log(result);
        }
    }
}

printMultiplicationTable(a);