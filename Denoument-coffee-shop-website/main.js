
javascript
        function sendEmail(){
            Email.send({
                  Host : "smtp.gmail.com",
                  Username : "Denoumentcoffeeshop@gmail.com",
                  Password : "finalprojectcomp2025",
                  To : 'dicr6434@agu.inter.edu',
                  From : document.getElementById("email").value,
                  Subject : "Formula de contacto Denouement",
                  Body: "Name" + document.getElementById("name").value
                  + "<br> Email " + document.getElementById("email").value
                  + "<br> Asunto " + document.getElementById("asunto").value
                  + "<br> message " + document.getElementById("message").value
            }).then(
              message => alert("Su mensaje a sido enviado")
            );
          }
