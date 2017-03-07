$(document).ready(function () {
    var verif1 = 0;
    var verif2 = 0;
    var verif3 = 0;
    var $nom = $("#nom");
    var $prenom = $("#prenom");
    var $mail = $("#mail");
    var $tel = $("#tel");
    var verif4 = 0;
    var $address = $("#address");
    var $password = $("#password");
    var $confpassword = $("#confpassword");
    var $bouton = $("#enregistrer");

    $bouton.hide();
    alert("js");
    $nom.keyup(function () {
        if ($(this).val().length >= 3) {
            // si la chaîne de caractères est inférieure à 5
            $(".divnom").addClass('has-success').removeClass('has-error');
            verif1 = 1
            if (verif1 == 1 && verif2 == 1 && verif3 == 1 && verif4 == 1)
                $bouton.show();
            ;
        } else {
            $(".divnom").addClass('has-error').removeClass('has-success');
            verif1 = 0;
            $bouton.hide();
        }
    });
    $prenom.keyup(function () {

        if ($(this).val().length >= 3) {

            $(".divprenom").addClass('has-success').removeClass('has-error');
            verif2 = 1;
            if (verif1 == 1 && verif2 == 1 && verif3 == 1 && verif4 == 1)
                $bouton.show();
        } else {
            $(".divprenom").addClass('has-error').removeClass('has-success');
            verif2 = 0;
            $bouton.hide();
        }
    });
    $address.keyup(function () {
        if ($(this).val() >= 2 && $(this).val().length <= 100) {

            $("#divaddress").addClass('has-success').removeClass('has-error');
            verif3 = 1;
            if (verif1 == 1 && verif2 == 1 && verif3 == 1 && verif4 == 1)
                $bouton.show();
        } else {
            $("#divaddress").addClass('has-error').removeClass('has-success');
            verif3 = 0;
            $bouton.hide();
        }
    });

    $tel.keyup(function () {
        if ($(this).val() >= 8) { // si la confirmation est différente du mot de passe

            $("#divtel").addClass('has-success').removeClass('has-error');
            verif4 = 1;
            if (verif1 == 1 && verif2 == 1 && verif3 == 1 && verif4 == 1)
                $bouton.show();
        } else {
            $("#divtel").addClass('has-error').removeClass('has-success');
            verif4 = 0;
            $bouton.hide();
        }
    });
    $mail.keyup(function () {
        if ($(this).val() >= 8) { // si la confirmation est différente du mot de passe

            $("#divmail").addClass('has-success').removeClass('has-error');
            verif4 = 1;
            if (verif1 == 1 && verif2 == 1 && verif3 == 1 && verif4 == 1)
                $bouton.show();
        } else {
            $("#divmail").addClass('has-error').removeClass('has-success');
            verif4 = 0;
            $bouton.hide();
        }
    });
    $password.keyup(function () {
        if ($(this).val() >= 8) { // si la confirmation est différente du mot de passe

            $("#divpassword").addClass('has-success').removeClass('has-error');
            verif4 = 1;
            if (verif1 == 1 && verif2 == 1 && verif3 == 1 && verif4 == 1)
                $bouton.show();
        } else {
            $("#divpassword").addClass('has-error').removeClass('has-success');
            verif4 = 0;
            $bouton.hide();
        }
    });
    $conf.keyup(function () {
        if ($(this).val() >= 8 && $(this).val() == $password.val()) { // si la confirmation est différente du mot de passe

            $("#divconf").addClass('has-success').removeClass('has-error');
            verif4 = 1;
            if (verif1 == 1 && verif2 == 1 && verif3 == 1 && verif4 == 1)
                $bouton.show();
        } else {
            $("#divconf").addClass('has-error').removeClass('has-success');
            verif4 = 0;
            $bouton.hide();
        }
    });


});