let a,b,c;

let figure = "TRIANGLE";
choose(figure, 2, 4, 8);

function choose(figure, a, b, c){
    switch(figure){
        case "RECTANGLE": {
            calculate("RECTANGLE", a, b);
            break;
        }
        case "TRAPEZE": {
            calculate("TRAPEZE", a, b, c);
            break;
        }
        case "PARALLELOGRAM": {
            calculate("PARALLELOGRAM", a, b);
            break;
        }
        case "TRIANGLE": {
            calculate("TRIANGLE", a, b);
            break;
        }
        default: {
            console.log("Nope.");
            break;
        }
    }
}

function calculate (figure, a, b, c){
    if(figure == "RECTANGLE" || figure == "PARALLELOGRAM"){
        console.log(a*b);
    }
    else if(figure == "TRAPEZE"){
        let result = ((a+b)*c) / 2;
        console.log(result);
    }
    else if(figure == "TRIANGLE"){
        result = (a*b)/2;
        console.log(result);
    }

}