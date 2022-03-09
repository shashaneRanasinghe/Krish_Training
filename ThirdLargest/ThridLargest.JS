const prompt = require("prompt-sync")();
// const input = prompt("Enter a sequence of numbers with space in between (Eg. 6 5 3 4) ");
input = "3 2 34 21 11 43 23 45 43"
// input = "2 3 1 4"

console.log(solution(input))

function solution(input){
    var arr = input.split(" ")
    numArr = arr.map((i) => Number(i));
    var numset = new Set(numArr)
    var nums = []
    numset.forEach(element => {
        nums.push(element)
    });
    sortList(nums,0,nums.length - 1)
    console.log(nums)
    if (nums.length  >= 3){
        return nums[nums.length - 3]
    }else{
        return nums[nums.length-1]
    }
}

function sortList(list) {

    if (list.length > 1) {

        var midIndex = Math.floor((list.length) / 2);

        var leftArray = list.slice(0,midIndex)
        var rightArray = list.slice(midIndex,list.length)

        sortList(leftArray);
        sortList(rightArray);
        var i = 0;
        var j = 0;
        var k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                list[k] = leftArray[i]
                i++;
            } else {
                list[k] = rightArray[j];
                j++;
            }
            k++;
        }
    
        while (i < leftArray.length) {
            list[k] = leftArray[i]
            i++;
            k++;
        }
        while (j < rightArray.length) {
            list[k] = rightArray[j];
            j++;
            k++;
        }
    }
    return;

}