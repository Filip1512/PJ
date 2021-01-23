let a = 4;
let b = 15;
let c = 3;

function checkDiv(a,b,c){
    
    while(a <= b){

        if (a%c == 0){
            console.log(a);
        }

        a++;
    }
}

checkDiv(a,b,c);