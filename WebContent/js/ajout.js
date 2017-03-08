$(document).ready(function () {

    var $multi = $("#divmultiPiece");
    var $apart = $("#divappartement");
    var $maison = $("#divmaison");
    var $chambre = $("#divchambre");
    var $type = $("#list");

    $type.focusout(function () {

        if ($type.val() === "appartement") {
            $maison.hide();
        }
        if ($type.val() === "maison") {
            $apart.hide();
        }
        if ($type.val() === "chambre") {
            $maison.hide();
            $apart.hide();
            $multi.hide();

        }
    });

});