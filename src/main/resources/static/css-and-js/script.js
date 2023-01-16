
function setPPos(element) {
    var widthElement = $(element).width();
    var posMilieu = ($(element).parent().width() / 2) - (widthElement / 2);
    $(element).css('left', posMilieu + 'px');
    console.log("Horizontal align set at :" + posMilieu + "px");
}


$(document).ready(function(){
    setPPos(".visible-p");
    setPPos(".h4");

    $(window).resize(function(){
        setPPos(".visible-p");
        setPPos("h4");
    })


})