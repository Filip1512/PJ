
function checkThree(){
    var triangle = [13,5,44];

    triangle.sort(function(a,b) { return a-b;});
    console.log(triangle);

    let a2 = Math.pow(triangle[0],2);
    let b2 = Math.pow(triangle[1],2);
    let c2 = Math.pow(triangle[2],2);

    console.log(a2);
    console.log(b2);
    console.log(c2);

    if (a2 + b2 == c2) {
        console.log("To jest trojka pitagorejska.")
    }
  	else{
      console.log("To nie jest trojka pitagorejska.")
    }

}

checkThree();