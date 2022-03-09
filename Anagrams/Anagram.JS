const prompt = require("prompt-sync")();

const input = prompt("Enter two words with a space in between (Eg. peach cheap) ");
console.log(isAnagram(input))


function isAnagram(inputText){
    try{
        const words = inputText.split(" ")
        firstWord = words[0].split("");
        secondWord = words[1].split("")
    }catch(Excpetion){
        return "please provide a valid input"
    }
    

    sortList(firstWord,0,firstWord.length -1)
    sortList(secondWord,0,secondWord.length -1)

    if (firstWord.length != secondWord.length){
        return "Not an Anagram"
    }
    for(i = 0; i < firstWord.length;i++){
        if (firstWord[i] != secondWord[i]){
            return ("Not an Anagram")
        }
    }
    return ("Anagram")
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
            if (leftArray[i].charCodeAt(0) <= rightArray[j].charCodeAt(0)) {
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