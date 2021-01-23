function Car(year, mileage, price){
    this.year = year;
    this.mileage = mileage;
    this.price = price;
    this.finalPrice = price;
    
    this.increaseFinalPrice = function(){
        this.finalPrice += 1000;
    };
    
    this.decreaseFinalPriceByYear = function(){
        this.finalPrice -= (currentYear-year)*1000;
    };
    this.decreaseFinalPriceByMileage = function(){
        this.finalPrice -= (mileage/100000)*1000;
    };
    this.changeMileageAndAge = function(mileageCount, ageCount){
        this.mileage = mileageCount;
        this.year = ageCount;
    };
    this.countFinalPrice = function(){

    };
}

var currentYear = new Date().getFullYear();
console.log(currentYear);

let Car1 = new Car(1999, 20000, 1000);
Car1.decreaseFinalPriceByYear();
Car1.changeMileageAndAge(5000, 2010);


console.log(Car1);


var carTab = [];

function addCarToArray(car){
    if(car.finalPrice > 10000){
        carTab.push(car);
    }
}

console.log(carTab);