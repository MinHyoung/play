$(document).ready(function() {
    /*
       Shorthand:
       
       $(function() {
        ...
        });
     */
    console.log("html document finished loading")
    $("a").before("<span>This is a link: </span>").click(function() {});
});

$(window).load(function() {
    console.log("entire page including style sheets, scripts and images finished loading");
});