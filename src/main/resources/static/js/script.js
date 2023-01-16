
function setPos(element) {
    let widthElement = ($(element).width() /2);
    let position = ($(element).parent().width() / 2);
    position = position - widthElement;
    $(element).css('left', position + 'px');
    console.log(position);

}

$(document).ready(function(){

    setPos(".visible-p");
    $(window).resize(function(){
        setPos(".visible-p");
    })


})