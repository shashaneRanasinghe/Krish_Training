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

function sortList(list, initIndex, finalIndex) {

    if (initIndex >= finalIndex) {
        return;
    }
        var midIndex = initIndex + Math.floor((finalIndex - initIndex) / 2);

        sortList(list, initIndex, midIndex);
        sortList(list, midIndex + 1, finalIndex);
        merge(list, initIndex, midIndex, finalIndex);
    
    
}

function merge(list, initIndex, middleIndex, finalIndex) {

    var sizeOfLeftArray = middleIndex - initIndex + 1;
	var sizeOfRightArray = finalIndex - middleIndex;

	var tempLeftArray = new Array(sizeOfLeftArray);
	var tempRightArray = new Array(sizeOfRightArray);

    for (i = 0; i < sizeOfLeftArray; i++) {
        tempLeftArray[i] = list[initIndex + i];
    }
    for (j = 0; j < sizeOfRightArray; j++) {
        tempRightArray[j] = list[middleIndex + 1 + j];
    }

    var i = 0;
    var j = 0;
    var k = initIndex;

    while (i < sizeOfLeftArray && j < sizeOfRightArray) {
        // console.log(tempLeftArray[i].charCodeAt(0),tempRightArray[j].charCodeAt(0))
        if (tempLeftArray[i].charCodeAt(0) <= tempRightArray[j].charCodeAt(0)) {
            list[k] = tempLeftArray[i]
            i++;
        } else {
            list[k] = tempRightArray[j];
            j++;
        }
        k++;
    }

    while (i < sizeOfLeftArray) {
        list[k] = tempLeftArray[i]
        i++;
        k++;
    }
    while (j < sizeOfRightArray) {
        list[k] = tempRightArray[j];
        j++;
        k++;
    }
}