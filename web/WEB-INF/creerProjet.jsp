<%-- 
    Document   : creerProjet
    Created on : 3 mars 2017, 12:43:20
    Author     : CHAFFORT
--%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Formulaire Projet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method="post" >
            <label for="titre">Créateur:</label>
            <input type="text" name="id_createur" id="id_createur" autofocus placeholder="Ex : MVC java" size="30" maxlength="10"required/>
            <span class="error">${titreMsg}</span>
            <br/>
            <label for="titre">Titre Projet:</label>
            <input type="text" name="titre" id="titre" autofocus placeholder="Ex : MVC java" size="30" maxlength="10"required/>
            <span class="error">${titreMsg}</span>
            <br/>
            <br/>
            <label for="Sujet">Sujet Projet :</label>
            <input type="text" name="sujet" id="sujet" placeholder="Ex : java" size="30" maxlength="50"required/>
            <br/>
            <label for="Sujet">Session formation :</label>
            <input type="text" name="id_session" id="id_session" placeholder="Ex : java" size="30" maxlength="10"required/>
            <br/>
            <br/>


            <br/>
            <label for="dateLimite">Date Limite  :</label>
            <input type="date" name="date_limite_rendu" id="date_limite_rendu" size="30" maxlength="10"required/>
            <br/>

            <input type='submit' name='validate' value='Créer Projet' >
            <input type='reset' name='annuler' value='Annulation'>
            </br>
            <div class="error">${msg}</div>
        </form>

    </body>
</html>
