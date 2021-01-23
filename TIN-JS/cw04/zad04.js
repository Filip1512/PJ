let fibCount = 7;

let fib = [0,1];

for (let i = 2; i <= fibCount; i++){
    let a = fib[i-1];
    let b = fib[i-2];

    fib.push(a+b);
}

console.table(fib);