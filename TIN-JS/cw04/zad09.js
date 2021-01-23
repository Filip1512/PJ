function pascal(rows){
    this.rows = rows; 

    this.triangle = new Array();

    for (var r = 0; r < rows; r++) {
        this.triangle[r] = new Array();

        for (var i = 0; i <= r; i++)
            { 
        if (i == 0 || i == r) 
            this.triangle[r][i] = 1;
        else
            this.triangle[r][i] = this.triangle[r-1][i-1]+this.triangle[r-1][i];
        }
    }

    for(i=0; i < this.triangle.length; i++)
    {
        console.log(this.triangle[i]);
    }
}

pascal(5);