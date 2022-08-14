function test() {
    for (let i = 100; i < 1000; i++) {
        let s = parseInt(i/100);
        let t = parseInt((i/10)%10);
        let h = i%10;
        if (s*s*s + t*t*t + h*h*h === i){
            confirm(i)
        }
    }
}